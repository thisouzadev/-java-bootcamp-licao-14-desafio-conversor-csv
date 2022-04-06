package com.trybe.conversorcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

    FileWriter escritorArquivo = null;
    BufferedWriter bufferedEscritor = null;

    for (File file : pastaDeEntradas.listFiles()) {
      leitorArquivo = new FileReader(file);
      bufferedLeitor = new BufferedReader(leitorArquivo);

      String conteudoLinha = bufferedLeitor.readLine();

      File meuArquivo = new File(pastaDeSaidas, file.getName());
      escritorArquivo = new FileWriter(meuArquivo);
      bufferedEscritor = new BufferedWriter(escritorArquivo);

      while (conteudoLinha != null) {
        String[] conteudo = conteudoLinha.split(",");
        if (conteudo[0].startsWith("Nome")) {
          bufferedEscritor.write(conteudoLinha);
          System.out.println(conteudoLinha);
        } else {
          String name = conteudo[0].toUpperCase();;
          String data = conteudo[1].replaceAll("(\\d+)/(\\d+)/(\\d+)", "$3-$2-$1");
          String email = conteudo[2];
          String cpf = conteudo[3].replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
          String formatado = name + "," + data + "," + email + "," + cpf;

          bufferedEscritor.write(formatado);
          System.out.println(formatado);
        }
        bufferedEscritor.newLine();
        conteudoLinha = bufferedLeitor.readLine();
      }
      bufferedEscritor.flush();
      leitorArquivo.close();
      bufferedLeitor.close();

    }
  }
}
