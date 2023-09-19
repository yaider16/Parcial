package Model;
import java.util.Arrays;

public class Meeting {
    private final int MAX_ASSISTANTS = 100;
    private Assistant[] assistants;
    public Meeting() {
        assistants = new Assistant[MAX_ASSISTANTS];
        Arrays.fill(assistants, null);
    }
    public void addParticipant(Assistant assistant){
        for (int i = 0; i < assistants.length; i++) {
            if(assistants[i] == null){
                assistants[i] = assistant;
                break;
            }
        }
    }
    public void removeParticipant(int id){
        for (int i = 0; i < assistants.length; i++) {
            if(assistants[i] != null && assistants[i].getId() == id){
                assistants[i] = null;
                break;
            }
        }
    }
    public int countParticipants(){
        int count =0;
        for(int i =0; i<assistants.length;i++){
            if(assistants[i] != null){
                count++;
            }
        }
        return count;
    }
    public int countAdultStudents(){
        int count =0;
        for (int i = 0; i < assistants.length; i++) {
            if (assistants[i] instanceof Student){
                Student student = (Student) assistants[i];
                if(student.isAdult()){
                    count++;
                }
            }
        }
        return count;
    }
    public int countTeachersByProfession(Profession profession){
        int count = 0;
        for (int i = 0; i < assistants.length; i++) {
            if (assistants[i] instanceof Teacher){
                Teacher teacher = (Teacher) assistants[i];
                if(teacher.getProfession() == profession){
                    count++;
                }
            }
        }
        return count;
    }
    public Dependency dependencyWithMoreNumber() {
        int countTalentoHumano = 0;
        int countTesoreria = 0;
        int countJuridica = 0;

        for (int i = 0; i < assistants.length; i++) {
            if (assistants[i] != null && assistants[i] instanceof Worker) {
                Worker worker = (Worker) assistants[i];
                switch (worker.getDependency()) {
                    case TALENTO_HUMANO -> countTalentoHumano++;
                    case TESORERIA -> countTesoreria++;
                    case JURIDICA -> countJuridica++;
                }
            }
        }

        if(countTalentoHumano== 0 && countTesoreria == 0 && countJuridica == 0){
            return null;
        } else if (countTalentoHumano > countTesoreria && countTalentoHumano > countJuridica) {
            return Dependency.TALENTO_HUMANO;
        } else if (countTesoreria > countTalentoHumano && countTesoreria > countJuridica) {
            return Dependency.TESORERIA;
        } else {
            return Dependency.JURIDICA;
        }
    }
    public boolean personExist(int id){
        for (int i = 0; i < assistants.length; i++) {
            if(assistants[i] != null && assistants[i].getId() == id){
                return true;
            }
        }
        return false;
    }
}
