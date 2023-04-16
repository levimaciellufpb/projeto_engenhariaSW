package ufpb.si.engenhariaSW.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DadosProjeto implements Dados{

    private final String path;
    private BufferedWriter writer;
    private BufferedReader reader;

    public DadosProjeto(String path){
        this.path = path;
    }

    @Override
    public void writeDados(List<String> DadosEmString) throws IOException {
        StringBuilder builder = new StringBuilder();

        try{
            writer = new BufferedWriter(new FileWriter(this.path));

            for(String s : DadosEmString){
                builder.append(s).append("\n");
                writer.write(builder.toString());
                builder.delete(0, builder.length());
            }

        }
        catch (IOException e){
            throw new IOException(e);
        }
        finally {
            if(writer != null)
                writer.close();
        }
    }

    @Override
    public List<String> readDados() throws IOException {

        List<String> readDados = new ArrayList<>();
        String line = null;

        try {
            reader = new BufferedReader(new FileReader(this.path));

            do{
                line = reader.readLine();
                if(line != null)
                    readDados.add(line);

            }while (line != null);
        }
        catch (IOException e){
            throw new IOException(e);
        }
        finally {
            if(reader != null)
                reader.close();
        }

        return readDados;
    }

}
