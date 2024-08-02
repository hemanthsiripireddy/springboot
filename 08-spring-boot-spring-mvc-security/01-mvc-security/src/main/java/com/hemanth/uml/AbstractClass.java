package com.hemanth.uml;

public abstract class AbstractClass implements Impl {

    abstract void hello();
}

interface Impl{
    void hi();
}

class Con extends AbstractClass{

    @Override
    void hello() {

    }

    @Override
    public void hi() {

    }
}
