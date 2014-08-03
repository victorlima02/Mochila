/*
 * The MIT License
 *
 * Copyright 2014 Victor de Lima Soares.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package mochila;

import ic.ce.populacional.Ambiente;
import ic.ce.populacional.algoritmo.AlgoritmoPopulacional;
import ic.ce.populacional.algoritmo.operadores.Gerador;
import ic.ce.populacional.algoritmo.operadores.Mutador;
import ic.ce.populacional.algoritmo.operadores.Recombinador;
import ic.ce.populacional.algoritmo.operadores.Seletor;
import java.util.Arrays;
import mochila.ambiente.Item;
import mochila.ambiente.ListaDeItens;
import mochila.ambiente.Mochila;
import mochila.ambiente.PopulacaoDeListas;
import mochila.operadores.Geracao;
import mochila.operadores.Mutacao;
import mochila.operadores.Recombinacao;
import mochila.operadores.Selecao;

/**
 *
 * @author Victor de Lima Soares
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Integer maxIndividuos = 50;
        Integer capacidadeDaMochila = 35;
        Double probabilidaDeCruzamento = 0.8;
        Double probabilidadeDeMutacao = 0.2;
        Integer maxInteracoes = 1000;
        
        
        Item itens[]=new Item[]{ //12 Itens
            new Item(10d,5d),
            new Item(18d,8d),
            new Item(12d,7d),
            new Item(14d,6d),
            
            new Item(13d,9d),
            new Item(11d,5d),
            new Item(8d,4d),
            new Item(6d,3d),
            
            new Item(6d,4d),
            new Item(15d,7d),
            new Item(4d,3d),
            new Item(1d,1d)
        }; 
        
        
        Ambiente<Double,ListaDeItens> ambiente = new Mochila(capacidadeDaMochila, Arrays.asList(itens));
        PopulacaoDeListas populacao = new PopulacaoDeListas(ambiente, maxIndividuos);

        Gerador gerador = new Geracao();
        Mutador mutador = new Mutacao(probabilidadeDeMutacao);
        Recombinador recombinador = new Recombinacao(probabilidaDeCruzamento);
        Seletor seletor = new Selecao();
                
        AlgoritmoPopulacional algoritmo = new Algoritmo();
            
        algoritmo.setAmbiente(ambiente);
        
        algoritmo.setGerador(gerador);
        algoritmo.setMutador(mutador);
        algoritmo.setRecombinador(recombinador);
        algoritmo.setSeletor(seletor);
        algoritmo.setMaxIteracoes(maxInteracoes);
        
        populacao.setIndividuos(gerador.getNAleatorios(maxIndividuos));
        algoritmo.setPopulacao(populacao);
                
        algoritmo.run();
        
        System.out.println(algoritmo.relatorio());
        System.out.println(populacao);
    }

}
