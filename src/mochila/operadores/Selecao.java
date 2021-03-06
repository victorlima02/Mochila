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

import ic.ce.populacional.algoritmo.operadores.Seletor;
import java.util.ArrayList;
import java.util.List;
import mochila.ambiente.ListaDeItens;

/**
 *
 * @author Victor de Lima Soares
 */
public class Selecao extends Seletor<Double, ListaDeItens> {

    @Override
    public List<ListaDeItens> getPais() {
        List<ListaDeItens> pais = new ArrayList<>(5);

        while(pais.size() < getPopulacao().size()) {
            pais.addAll(melhoresEntreAleatorios(2, 5));
        }

        return pais;
    }

    @Override
    public List<ListaDeItens> getSobreviventes() {
        return getPopulacao().getNMelhores(getPopulacao().getMaxIndividuos());
    }
}
