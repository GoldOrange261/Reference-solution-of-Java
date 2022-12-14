import java.awt.*;
import java.awt.event.*;

public class App extends Frame implements ActionListener {

    App(String title) { super(title); }

    static App frm = new App("BMI");
    static Panel fields = new Panel(new GridLayout(5, 1));
    static Panel textFields = new Panel(new GridLayout(3, 1, 0, 20));
    static Panel unitHint = new Panel(new GridLayout(2, 1));
    static TextField nameField = new TextField(1);
    static TextField weightField = new TextField(1);
    static TextField heightField = new TextField(1);
    static Checkbox male = new Checkbox("男生");
    static Checkbox female = new Checkbox("女生");
    static Choice ageField = new Choice();
    static Label weightDisplay = new Label("", Label.CENTER);
    static Label suggestionDisplay = new Label("", Label.CENTER);
    static Button computeBMI = new Button("Compute BMI");
    static Button exitButton = new Button("Exit");
    static Font GeneralBold = new Font("Serief", Font.BOLD, 16);

    static String[] FieldsDisplay = {"名字", "體重", "身高", "性別", "年齡"};
    static String[] unitHintDisplay = {"(公斤)", "(公分)"};

    public static void main(String[] args) {
        
        CheckboxGroup genderCheckboxGrp = new CheckboxGroup();

        frm.setLayout(null);
        frm.setResizable(false);
        frm.setSize(500, 500);

        for(String displayName : FieldsDisplay) {
            Label lab = new Label(displayName, Label.LEFT);
            lab.setFont(GeneralBold);
            fields.add(lab);
        }
        fields.setBounds(40, 40, 50, 200);

        for(String displayName : unitHintDisplay) {
            Label lab = new Label(displayName, Label.LEFT);
            lab.setFont(GeneralBold);
            unitHint.add(lab);
        }
        unitHint.setBounds(210, 80, 50, 80);

        textFields.add(nameField); textFields.add(weightField); textFields.add(heightField);
        textFields.setBounds(100, 52, 100, 100);

        male.setCheckboxGroup(genderCheckboxGrp); female.setCheckboxGroup(genderCheckboxGrp);
        male.setBounds(100, 160, 50, 40);
        male.setFont(GeneralBold);
        female.setBounds(165, 160, 50, 40);
        female.setFont(GeneralBold);

        for(int i = 1;i <= 150;i++) ageField.add(String.valueOf(i));
        ageField.setBounds(100, 210, 75, 30);

        weightDisplay.setBounds(0, 275, 500, 60);
        weightDisplay.setForeground(Color.BLUE);
        weightDisplay.setFont(new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 30));

        suggestionDisplay.setBounds(0, 340, 500, 40);
        suggestionDisplay.setFont(new Font("Serief", Font.PLAIN, 16));

        computeBMI.setBounds(40, 415, 200, 50);
        computeBMI.addActionListener(frm);
        exitButton.setBounds(275, 415, 175, 50);
        exitButton.addActionListener(frm);

        frm.add(fields); frm.add(unitHint);
        frm.add(textFields);
        frm.add(male); frm.add(female);
        frm.add(ageField);
        frm.add(weightDisplay); frm.add(suggestionDisplay);
        frm.add(computeBMI); frm.add(exitButton);

        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frm.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        Button btn = (Button) e.getSource();
        if(btn == computeBMI) ComputeBMI();
        else System.exit(0);

    }

    private void ComputeBMI() {

        int age = ageField.getSelectedIndex() + 1;
        double weight = Double.parseDouble(weightField.getText());
        double height = Double.parseDouble(heightField.getText()) / 100;
        String name = nameField.getText();
        String suggestion;

        double BMI = weight / (height * height);

        if(male.getState()) suggestion = String.format("%s(%d歲, 男生):", name, age);
        else suggestion = String.format("%s(%d歲, 女生):", name, age);

        if(BMI < 18.5) { weightDisplay.setText("Under weight"); suggestion += "Eat more !"; }
        else if(BMI < 24) { weightDisplay.setText("Normal weight"); suggestion += "Great!"; }
        else if(BMI < 27) { weightDisplay.setText("Over weight"); suggestion += "Remember to do exercises"; }
        else { weightDisplay.setText("Obesity"); suggestion += "Go on diet, now!"; }

        suggestionDisplay.setText(suggestion);

    }

}