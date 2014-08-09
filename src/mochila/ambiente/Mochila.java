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
package mochila.ambiente;


import ic.ce.base.Ambiente;
import ic.ce.base.Caracteristica;
import java.util.List;

/**
 *
 * @author Victor de Lima Soares
 */
public class Mochila extends Ambiente<Double,ListaDeItens> {

    double capacidade;
    double parametroDePenalidade = 3;
    List<Item> itensDisponiveis;

    public Mochila(double capacidade,List<Item> itensDisponiveis) {
        this.capacidade = capacidade;
        this.itensDisponiveis = itensDisponiveis;
    }
    
    @Override
    public Double avalia(ListaDeItens lista) {

        Double soma = 0d;
        Double peso = 0d;
        
        for (Caracteristica i : lista) {
            Item item = (Item) i;
            if (item.getBit()) {
                soma += item.getValorItem();
                peso += item.getPeso();
            }
        }
        
        if(peso > this.getCapacidade()){ // Penalização
            soma-=parametroDePenalidade*(peso-getCapacidade());
        }
        
        return soma;
    }

    public Double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }
    
    public Item getItem(int i){
        return itensDisponiveis.get(i);
    }
    
    public int getNItensDisponiveis(){
        return itensDisponiveis.size();
    }
}
