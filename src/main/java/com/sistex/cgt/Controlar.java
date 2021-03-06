/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Item;
import com.sistex.cgd.Dao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public abstract class  Controlar implements InterfaceControlar{
    protected final  Dao dao;
    protected final Fabrica fabrica;
    protected HttpServletRequest request;
    
    public Controlar(Fabrica f){
        dao = f.criaDao();
        fabrica = f;
    }
    
    @Override
    public void cadastrar() {
        Item item = getItem();
        dao.cadastrar(item);
    }
    
    @Override
    public void excluir() {
        Item item = getItem();
        dao.excluir(item);
    }
    
    @Override
    public List<Item> listarVinculados() {
        Item item = getItem();
        return dao.listarVinculo(item);
    }
    
    @Override
    public List<Item> listar() {return dao.listar();}

    @Override
    public boolean existe(Item item){return dao.existe(item);}
    
    @Override
    public void setRequest(HttpServletRequest request) {this.request = request;}
    
    @Override
    public boolean excluirAll(){return dao.excluirAll();}
    
    @Override
    public boolean cadastrar(Item item){return dao.cadastrar(item);}
    
    @Override
    public boolean excluir(Item item){return dao.excluir(item);}
    
    @Override
    public boolean solicitarPedido() {return false;}

    @Override
    public List<Item> monitorarPedidos() {return null;}

    
}
