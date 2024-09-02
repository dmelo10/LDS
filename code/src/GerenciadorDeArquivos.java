import java.io.ObjectOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeArquivos {

    public static <T> void salvarAll(List<T> componenteAll) {
        if (!(componenteAll==null)&&!componenteAll.isEmpty()) {
            try {
                FileOutputStream fOutputStrem = new FileOutputStream(
                        new File(componenteAll.getFirst().getClass().getSimpleName() + ".txt"));

                ObjectOutputStream oOutputStream = new ObjectOutputStream(fOutputStrem);

                for (T componente : componenteAll) {
                    oOutputStream.writeObject(componente);
                }

                oOutputStream.close();
                fOutputStrem.close();
            } catch (Exception e) {
                System.out.println("salvarAll; GerenciadorDeArquivos: " + e);
            }
        }
    }

    public static <T> List<T> lerArquivoDaClasse(Class<?> classe) throws IOException {

        try {
            FileInputStream fInput = new FileInputStream(
                    new File(classe.getSimpleName() + ".txt"));
            ObjectInputStream oInput = new ObjectInputStream(fInput);

            List<T> compList = new ArrayList<>();

            while (true) {
                try {
                    @SuppressWarnings("unchecked")
                    T readComp = (T) oInput.readObject();

                    if (readComp != null) {
                        compList.add(readComp);
                    }
                } catch (EOFException e) {
                    oInput.close();
                    return compList;
                }
            }
        }catch(FileNotFoundException fileE){
            new File(classe.getSimpleName() + ".txt").createNewFile();
            
            return null;
        }catch(EOFException eofe){
            return null;
        } catch (Exception e) {
            System.out.println("lerArquivo; GerenciadorDeArquivos: " + e);
            return null;
        }

    }
}