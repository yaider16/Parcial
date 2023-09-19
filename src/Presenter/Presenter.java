package Presenter;

import Model.*;
import View.View;

public class Presenter {
    public final View view = new View();
    public Meeting meeting;

    public static void main(String[] args) {
        Presenter presenter = new Presenter();
        presenter.menu();
    }

    public void menu(){
        meeting = new Meeting();
        String[] options = {"Agregar participante", "Eliminar participante", "Contar participantes", "Contar estudiantes adultos", "Contar profesores por profesion", "Dependencia con mas participantes", "Salir"};
        String option;
        do{
            option = view.askVariousInfo(options, "Bienvenido al sistema de registro");
            switch (option){
                case "Agregar participante" -> addParticipant();
                case "Eliminar participante" -> removeParticipant();
                case "Contar participantes" -> countParticipants();
                case "Contar estudiantes adultos" -> countAdultStudents();
                case "Contar profesores por profesion" -> countTeachersByProfession();
                case "Dependencia con mas participantes" -> dependencyWithMoreNumber();
                case "Salir" -> {
                    view.showMessage("Gracias por usar el sistema");
                    System.exit(0);
                }
            }
        }while(true);
    }

    public void addParticipant(){
        String[] options = {"Estudiante", "Profesor", "Empleado"};
        String option = view.askVariousInfo(options, "Seleccione el tipo de participante");
        Assistant assistant = null;

        String firstName = view.askInfo("Ingrese el nombre del participante");
        String lastName = view.askInfo("Ingrese el apellido del participante");
        int id = Integer.parseInt(view.askInfo("Ingrese la identificacion del participante"));

        switch (option){
            case "Estudiante"->{
                int age = Integer.parseInt(view.askInfo("Ingrese la edad del estudiante"));
                int code = Integer.parseInt(view.askInfo("Ingrese el codigo del estudiante"));
                assistant = new Student(id, firstName, lastName,code,age);
            }
            case "Profesor"->{
                String[] optionsProfession = {"INGENIERO", "LICENCIADO", "ADMINISTRADOR", "ABOGADO"};
                Profession profession = Profession.valueOf(view.askVariousInfo(optionsProfession, "Seleccione la profesion del profesor"));
                assistant = new Teacher(id, firstName, lastName, profession);
            }
            case "Empleado"->{
                String[] optionsDependency = {"TALENTO_HUMANO", "TESORERIA", "JURIDICA"};
                Dependency dependency = Dependency.valueOf(view.askVariousInfo(optionsDependency, "Seleccione la dependencia del empleado"));
                int salary = Integer.parseInt(view.askInfo("Ingrese el salario del empleado"));
                assistant = new Worker(id, firstName, lastName, salary, dependency);
            }
        }
        view.showMessage("Participante agregado con exito");
        meeting.addParticipant(assistant);
    }
    public void removeParticipant(){
        int id = Integer.parseInt(view.askInfo("Ingrese la identificacion del participante"));
        if(meeting.personExist(id)){
            meeting.removeParticipant(id);
            view.showMessage("Participante eliminado con exito");
        }else{
            view.showMessage("El participante no existe");
        }

    }
    public void countParticipants(){
        view.showMessage("La cantidad de participantes es: " + meeting.countParticipants());
    }
    public void countAdultStudents(){
        int cantAdultStudents = meeting.countAdultStudents();
        view.showMessage("La cantidad de estudiantes adultos es: " + cantAdultStudents);
    }
    public void countTeachersByProfession(){
        String[] options = {"INGENIERO", "LICENCIADO", "ADMINISTRADOR", "ABOGADO"};
        Profession profession = Profession.valueOf(view.askVariousInfo(options, "Seleccione la profesion del profesor"));
        int cantTeachers = meeting.countTeachersByProfession(profession);
        view.showMessage("La cantidad de profesores de la profesion " + profession + " es: " + cantTeachers);
    }
    public void dependencyWithMoreNumber(){
        Dependency dependency = meeting.dependencyWithMoreNumber();
        if(dependency!=null){
            view.showMessage("La dependencia con mas participantes es: " + dependency);
        }else{
            view.showMessage("No hay participantes");
        }
    }

}
