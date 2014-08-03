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
package mochila.operadores;


import ic.ce.populacional.Ambiente;
import ic.ce.populacional.Populacao;
import ic.ce.populacional.algoritmo.operadores.Gerador;
import ic.ce.populacional.utilidades.Binarios;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mochila.ambiente.Item;
import mochila.ambiente.ListaDeItens;
import mochila.ambiente.Mochila;
import mochila.ambiente.PopulacaoDeListas;

/**
 *
 * @author Victor de Lima Soares
 */
public class Geracao extends Gerador<ListaDeItens> {

    @Override
    public ListaDeItens get() {
        int nItensDisponivies = ((Mochila) getAmbiente()).getNItensDisponiveis();
        ListaDeItens nova = new ListaDeItens(nItensDisponivies);
        return nova;
    }

    @Override
    public ListaDeItens getAleatorio()  {

        int nItensDisponivies = ((Mochila) getAmbiente()).getNItensDisponiveis();
        ListaDeItens nova = new ListaDeItens(nItensDisponivies);

        ArrayList<Item> cromossomo = new ArrayList<>();

        List<Boolean> indices = Binarios.arrayAleatorioUniforme(((Mochila) getAmbiente()).getNItensDisponiveis());

        for (int i = 0; i < ((Mochila) getAmbiente()).getNItensDisponiveis(); i++) {
            Item novo = ((Mochila) getAmbiente()).getItem(i).copia();
            novo.setBit(indices.get(i));
            cromossomo.add(novo);
        }

        nova.setCaracteristicas(cromossomo);
        return nova;
    }

}
