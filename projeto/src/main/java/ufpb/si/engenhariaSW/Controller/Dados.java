package ufpb.si.engenhariaSW.Controller;

import java.io.*;
import java.util.List;

public interface Dados {

    public void writeDados(List<String> texto) throws IOException;
    public List<String> readDados() throws IOException;

}
