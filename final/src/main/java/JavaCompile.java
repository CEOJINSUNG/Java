import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.tools.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class JavaCompile extends JFrame {

    private JPanel contentPane;
    private JPanel top;
    private JLabel topLabel;
    private JButton adminButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton submitButton;
    private JPanel left;
    private JTextArea problemTitle;
    private JTextArea problemDescription;
    private JTextArea inputTitle;
    private JTextArea inputDescription;
    private JTextArea outputTitle;
    private JTextArea outputDescription;
    private JTextArea code;
    private JavaCompiler compiler;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JavaCompile javaCompile = new JavaCompile();
                    javaCompile.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public JavaCompile() {
        // ========== jframe attribute setting ==========
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 900, 600);

        // ========== content pane setting ==========
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // ========== top panel setting ==========
        top = new JPanel();
        top.setLayout(new GridLayout(0, 5, 0, 0));
        contentPane.add(top, BorderLayout.NORTH);

        topLabel = new JLabel();
        topLabel.setText("Algorithm Judge - User Mode");
        top.add(topLabel);

        adminButton = new JButton("Admin Mode");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        top.add(adminButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        top.add(nextButton);

        previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        top.add(previousButton);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new SourceCompile()).execute();
            }
        });
        top.add(submitButton);

        // ========== Problem / Input / Output Panel Setting ==========
        left = new JPanel();
        left.setLayout(new GridLayout(3, 0, 0, 0));
        contentPane.add(left, BorderLayout.WEST);
        left.add(new ProblemPanel());
        left.add(new InputPanel());
        left.add(new OutputPanel());

        // ========== Code Panel setting ==========
        code = new JTextArea();
        code.setEditable(true);
        code.setLineWrap(true);
        contentPane.add(code, BorderLayout.CENTER);

    }

    class ProblemPanel extends JPanel {
        public ProblemPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            problemTitle = new JTextArea("Problem");
            problemTitle.setEditable(false);
            problemTitle.setBackground(Color.GRAY);
            problemTitle.setPreferredSize(new Dimension(300, 20));

            problemDescription = new JTextArea();
            problemDescription.setEditable(false);
            problemDescription.setBackground(Color.WHITE);
            problemDescription.setPreferredSize(new Dimension(300, 180));
            problemDescription.setLineWrap(true);

            add(problemTitle);
            add(problemDescription);
        }
    }

    class InputPanel extends JPanel {
        public InputPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            inputTitle = new JTextArea("Input");
            inputTitle.setEditable(false);
            inputTitle.setBackground(Color.GRAY);
            inputTitle.setPreferredSize(new Dimension(300, 20));

            inputDescription = new JTextArea();
            inputDescription.setEditable(true);
            inputDescription.setBackground(Color.WHITE);
            inputDescription.setPreferredSize(new Dimension(300, 180));
            inputDescription.setLineWrap(true);

            add(inputTitle);
            add(inputDescription);
        }
    }

    class OutputPanel extends JPanel {
        public OutputPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            outputTitle = new JTextArea("Output");
            outputTitle.setEditable(false);
            outputTitle.setBackground(Color.GRAY);
            outputTitle.setPreferredSize(new Dimension(300, 20));

            outputDescription = new JTextArea();
            outputDescription.setEditable(true);
            outputDescription.setBackground(Color.WHITE);
            outputDescription.setPreferredSize(new Dimension(300, 180));
            outputDescription.setLineWrap(true);

            add(outputTitle);
            add(outputDescription);
        }
    }

    class SourceCompile extends SwingWorker<String, Object> {
        @Override
        protected String doInBackground() throws Exception {
            return compileCode(1);
        }
    }

    public String compileCode(int index) {
        outputDescription.setText("Compiling.." );
        String compResult = null;
        if (compiler==null) {
            compiler = ToolProvider.getSystemJavaCompiler();
        }
        if ( compiler!=null ) {
            // 1. Write file from code
            String sourceCode = code.getText();
            String sourceName = "Problem" + Integer.toString(index).trim();
            if ( sourceName.toLowerCase().endsWith(".java") ) {
                sourceName = sourceName.substring(0,sourceName.length()-5 );
            }

            // 2. Read File and Compile
            JavaSourceFromString javaString = new JavaSourceFromString(sourceName, sourceCode);
            ArrayList<JavaSourceFromString> javaSourceFromStrings = new ArrayList<>();
            javaSourceFromStrings.add(javaString);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
            DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<>();

            JavaCompiler.CompilationTask task = compiler.getTask(outputStreamWriter, null, diagnosticsCollector, null, null, javaSourceFromStrings);
            boolean success = task.call();
            List<Diagnostic<? extends JavaFileObject>> diagnostics = diagnosticsCollector.getDiagnostics();
            for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics) {
                System.out.println(diagnostic.getCode());
                outputDescription.setText(diagnostic.getCode());
                System.out.println(diagnostic.getMessage(null));
            }

            try (URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {
                new File(System.getProperty("user.dir")).toURI().toURL()
            })) {
                Class<?> exampleClass = Class.forName("Problem1", true, classLoader);
                Method mainMethod = exampleClass.getMethod("main", String[].class);
                if (!Modifier.isStatic(mainMethod.getModifiers())) {
                    throw new IllegalStateException("Main Method is not Static");
                }
                Object value = mainMethod.invoke(null, (Object) new String[0]);
                System.out.println(value);
                outputDescription.setText(byteArrayOutputStream.toString().replaceAll("\t", "  "));
                compResult = "Compile Success: " + success;
                outputDescription.append(compResult);
                outputDescription.setCaretPosition(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            outputDescription.setText("No compilation possible - error");
            JOptionPane.showMessageDialog(this,
                "No compiler is available to this runtime!",
                "Compiler not found",
                JOptionPane.ERROR_MESSAGE
            );
            System.exit(-1);
        }
        return compResult;
    }

    class JavaSourceFromString extends SimpleJavaFileObject {
        final String code;

        JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.','/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }

}
