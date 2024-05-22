package cg.projeto.Motor.Componentes._3D;

import cg.projeto.Motor.Tela;

public class Esfera extends ComponenteBase3D<Esfera> {

    public float raio = 1;

    public Esfera redimensionarComponente(float raio){
        this.raio = raio;
        this.altura = raio * 2;
        this.largura = raio * 2;
        return this;
    }

    public void desenharComponente(){

        Tela.drawer2D.glColor4f(this.cor[0], this.cor[1], this.cor[2], this.cor[3]);

        Tela.drawer2D.glPushMatrix();

        Tela.drawer2D.glTranslatef(this.x, this.y, this.z);

        Tela.drawer2D.glRotatef(this.rotacao[1], 1, 0, 0);
        Tela.drawer2D.glRotatef(this.rotacao[0], 0, 1, 0);
        Tela.drawer2D.glRotatef(this.rotacao[2], 0, 0, 1);

        if(this.preencher) Tela.drawer3D.glutSolidSphere(this.raio, 30, 30);
        else Tela.drawer3D.glutWireSphere(this.raio, 30, 30);

        Tela.drawer2D.glPopMatrix();

    }

}