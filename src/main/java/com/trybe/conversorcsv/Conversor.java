package com.trybe.conversorcsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Conversor {

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou gravar os
   *         arquivos de saída.
   */
  public static void main(String[] args) throws IOException {
    File pastaDeEntradas = new File("./entradas/");
    File pastaDeSaidas = new File("./saidas/");
    new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
  }

  /**
   * Converte todos os arquivos CSV da pasta de entradas. Os resultados são gerados na pasta de
   * saídas, deixando os arquivos originais inalterados.
   *
   * @param pastaDeEntradas Pasta contendo os arquivos CSV gerados pela página web.
   * @param pastaDeSaidas Pasta em que serão colocados os arquivos gerados no formato requerido pelo
   *        subsistema.
   *
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou gravar os
   *         arquivos de saída.
   */
  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) throws IOException {
    // TODO: Implementar.
    if (!pastaDeSaidas.exists()) {
      pastaDeSaidas.mkdir();
    }

    FileReader leitorArquivo = null;
    BufferedReader bufferedLeitor = null;
    for (File file : pastaDeEntradas.listFiles()) {
      leitorArquivo = new FileReader(file);
      bufferedLeitor = new BufferedReader(leitorArquivo);

      String conteudoLinha = bufferedLeitor.readLine();
      while (conteudoLinha != null) {
        System.out.println(conteudoLinha);
        conteudoLinha = bufferedLeitor.readLine();
      }
      leitorArquivo.close();
      bufferedLeitor.close();
    }

  }
}
