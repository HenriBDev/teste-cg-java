package cg.projeto.Eventos;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

import cg.projeto.Main;
import cg.projeto.Debug.ModosEdicao;
import cg.projeto.Jogo.GameLoop;
import cg.projeto.Jogo.Estados.EstadosJogo;
import cg.projeto.Motor.Tela;

public class Keyboard implements KeyListener{
    
    public Keyboard(){}
    
    public void keyPressed(KeyEvent e) {        

        System.out.println("Key pressed: " + e.getKeyCode());

        switch(e.getKeyCode()){

            case KeyEvent.VK_ESCAPE:
                System.exit(0);
            break;

            // Setas
            case KeyEvent.VK_RIGHT:
                if(Main.DEBUG)
                {
                    switch(Tela.modoEdicao)
                    {
                        case MOVER:
                            Tela.posicaoCamera[0]+=10;
                        break;
                        case ROTACIONAR:
                            Tela.rotacaoCamera[0]+=1;
                        break;
                    }
                }
            break;

            case KeyEvent.VK_LEFT:
                if(Main.DEBUG)
                {
                    switch(Tela.modoEdicao)
                    {
                        case MOVER:
                            Tela.posicaoCamera[0]-=10;
                        break;
                        case ROTACIONAR:
                            Tela.rotacaoCamera[0]-=1;
                        break;
                    }
                }
            break;

            case KeyEvent.VK_UP:
                if(Main.DEBUG)
                {
                    switch(Tela.modoEdicao)
                    {
                        case MOVER:
                            Tela.posicaoCamera[1]+=10;
                        break;
                        case ROTACIONAR:
                            Tela.rotacaoCamera[1]+=1;
                        break;
                    }
                }
            break;

            case KeyEvent.VK_DOWN:
                if(Main.DEBUG)
                {
                    switch(Tela.modoEdicao)
                    {
                        case MOVER:
                            Tela.posicaoCamera[1]-=10;
                        break;
                        case ROTACIONAR:
                            Tela.rotacaoCamera[1]-=1;
                        break;
                    }
                }
            break;

            // Debug
            case KeyEvent.VK_M:
                if(Main.DEBUG)
                {
                    if(Tela.modoEdicao != ModosEdicao.MOVER)
                    {
                        Tela.modoEdicao = ModosEdicao.MOVER;
                    }
                }
            break;

            case KeyEvent.VK_R:

                if(Main.DEBUG && Tela.modoEdicao != ModosEdicao.ROTACIONAR)
                {
                    Tela.modoEdicao = ModosEdicao.ROTACIONAR;
                }
                else if(GameLoop.estado == EstadosJogo.JOGANDO || GameLoop.estado == EstadosJogo.PERDEU)
                {
                    Tela.jogo = new GameLoop();
                    Tela.jogo.resetarPosicoes();
                    if(GameLoop.estado == EstadosJogo.PERDEU) GameLoop.estado = EstadosJogo.JOGANDO;
                }
            break;
            
            case KeyEvent.VK_G:

                if(Main.DEBUG && Tela.modoEdicao != ModosEdicao.GRID)
                {
                    Tela.modoEdicao = ModosEdicao.GRID;
                }
            break;

            // Jogo
            case KeyEvent.VK_ENTER:

                if(!(Main.DEBUG) && GameLoop.estado == EstadosJogo.INICIAL)
                {
                    Tela.jogo.mudarEstado(EstadosJogo.JOGANDO);
                }
            break;

            case KeyEvent.VK_P:
                if(!(Main.DEBUG))
                {
                    if(GameLoop.estado == EstadosJogo.JOGANDO) Tela.jogo.mudarEstado(EstadosJogo.PAUSADO);
                    else if(GameLoop.estado == EstadosJogo.PAUSADO) Tela.jogo.mudarEstado(EstadosJogo.JOGANDO);
                }
            break;
        }
    }

    public void keyReleased(KeyEvent e) { }

}