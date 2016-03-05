package trabalho1.criadores;

import trabalho1.model.Disciplina;
import trabalho1.model.Horario;

import java.util.ArrayList;
import java.util.List;

import static trabalho1.enums.Area.*;
import static trabalho1.enums.Semestre.*;
import static trabalho1.criadores.CriaHorario.*;

//import lombok.Singleton;

//@Singleton
public final class CriadorDisciplinas {

    private static List<Disciplina> displinas = new ArrayList<>(45);

    private static List<Disciplina> aprovadas = new ArrayList<>(45);

    private static Disciplina CP = Disciplina.builder().nome("Computação Digital").qtdCreditos(4).semestre(SEMESTRE_1).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina IC = Disciplina.builder().nome("Introdução Computação").qtdCreditos(2).semestre(SEMESTRE_1).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina UCP = Disciplina.builder().nome("Uniersidade Ciencia e Pesquisa").qtdCreditos(4).semestre(SEMESTRE_1).areaConhecimento(CONTEXTO_SOCIAL_PROFISIONAL).build();
    private static Disciplina FMC = Disciplina.builder().nome("Fundamentos Matematicos").qtdCreditos(4).semestre(SEMESTRE_1).areaConhecimento(MATEMATICA).build();
    private static Disciplina PC = Disciplina.builder().nome("Programacao Computadores").qtdCreditos(6).semestre(SEMESTRE_1).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina EF1 = Disciplina.builder().nome("Educação Fisica").qtdCreditos(2).semestre(SEMESTRE_1).areaConhecimento(CONTEXTO_SOCIAL_PROFISIONAL).build();

    private static Disciplina AC = Disciplina.builder().nome("Arquitetura de Computadores").qtdCreditos(4).semestre(SEMESTRE_2).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina OEG = Disciplina.builder().nome("Optativa Eixo Geral").qtdCreditos(4).semestre(SEMESTRE_2).areaConhecimento(CONTEXTO_SOCIAL_PROFISIONAL).build();
    private static Disciplina LC = Disciplina.builder().nome("Logica Computacao").qtdCreditos(4).semestre(SEMESTRE_2).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina ALC = Disciplina.builder().nome("Algebra Linear").qtdCreditos(4).semestre(SEMESTRE_2).areaConhecimento(MATEMATICA).build();
    private static Disciplina POO1 = Disciplina.builder().nome("Programacao Orientada I").qtdCreditos(4).semestre(SEMESTRE_2).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina EF2 = Disciplina.builder().nome("Educação Fisica II").qtdCreditos(2).semestre(SEMESTRE_2).areaConhecimento(CONTEXTO_SOCIAL_PROFISIONAL).build();

    private static Disciplina SO = Disciplina.builder().nome("Sistemas Operacioanis").qtdCreditos(4).semestre(SEMESTRE_3).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina EST = Disciplina.builder().nome("Estatistica").qtdCreditos(4).semestre(SEMESTRE_3).areaConhecimento(MATEMATICA).build();
    private static Disciplina TDC = Disciplina.builder().nome("Teoria da Computação").qtdCreditos(4).semestre(SEMESTRE_3).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina POO2 = Disciplina.builder().nome("Programação Orientada II").prerequisito(POO1).qtdCreditos(4).semestre(SEMESTRE_2).horarios(new Horario[]{SEG1, QUI1}).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina AED = Disciplina.builder().nome("Algoritmos Estrutura de Dados").prerequisito(POO1).qtdCreditos(4).semestre(SEMESTRE_3).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();

    private static Disciplina PCD = Disciplina.builder().nome("Protocolo Comunicação").qtdCreditos(2).semestre(SEMESTRE_4).areaConhecimento(TECNOLOGIAS_COMPUTACAO).build();
    private static Disciplina MQ = Disciplina.builder().nome("Métodos Quantitativos").qtdCreditos(4).semestre(SEMESTRE_4).areaConhecimento(MATEMATICA).build();
    private static Disciplina LF = Disciplina.builder().nome("Linguagens Formais").qtdCreditos(2).semestre(SEMESTRE_4).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina LDP = Disciplina.builder().nome("Linguagens de Programação").qtdCreditos(4).semestre(SEMESTRE_4).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina TDG = Disciplina.builder().nome("Teoria dos Grafos").prerequisito(AED).qtdCreditos(4).semestre(SEMESTRE_4).areaConhecimento(FUNDAMENTOS_COMPUTACAO).build();
    private static Disciplina DSC = Disciplina.builder().nome("Desafios Sociais").qtdCreditos(4).semestre(SEMESTRE_4).areaConhecimento(CONTEXTO_SOCIAL_PROFISIONAL).build();

    private static Disciplina RDC = Disciplina.builder().nome("Redes de Computadores").qtdCreditos(4).semestre(SEMESTRE_5).areaConhecimento(TECNOLOGIAS_COMPUTACAO).build();
    private static Disciplina BD1 = Disciplina.builder().nome("Banco de Dados 1").qtdCreditos(4).semestre(SEMESTRE_5).areaConhecimento(TECNOLOGIAS_COMPUTACAO).build();
    private static Disciplina COP = Disciplina.builder().nome("Compiladores").prerequisito(LF).qtdCreditos(4).semestre(SEMESTRE_5).areaConhecimento(TECNOLOGIAS_COMPUTACAO).build();
    private static Disciplina EDS = Disciplina.builder().nome("Engenharia de Software").prerequisito(POO2).qtdCreditos(4).semestre(SEMESTRE_5).horarios(new Horario[]{SEG2, QUI2}).areaConhecimento(TECNOLOGIAS_COMPUTACAO).build();
    private static Disciplina DACD = Disciplina.builder().nome("Desv. Apli. Concorentes e Distribuidas").prerequisito(POO2).qtdCreditos(4).semestre(SEMESTRE_5).areaConhecimento(TECNOLOGIAS_COMPUTACAO).build();

    private static Disciplina CO = Disciplina.builder().nome("Comportamento Organzazional").qtdCreditos(4).semestre(SEMESTRE_6).areaConhecimento(CONTEXTO_SOCIAL_PROFISIONAL).build();
    private static Disciplina OPT1 = Disciplina.builder().nome("Optativa I").qtdCreditos(4).semestre(SEMESTRE_6).areaConhecimento(FLEXIBILIZACAO).build();
    private static Disciplina BD2 = Disciplina.builder().nome("Banco de Dados 2").prerequisito(COP).qtdCreditos(4).semestre(SEMESTRE_6).areaConhecimento(TECNOLOGIAS_COMPUTACAO).horarios(new Horario[]{SEG1, QUI1}).build();
    private static Disciplina PS1 = Disciplina.builder().nome("Processo de Software 1").prerequisito(EDS).qtdCreditos(4).semestre(SEMESTRE_6).areaConhecimento(TECNOLOGIAS_COMPUTACAO).build();
    private static Disciplina SD = Disciplina.builder().nome("Sistemas Distribuidos").prerequisito(DACD).qtdCreditos(4).semestre(SEMESTRE_6).areaConhecimento(TECNOLOGIAS_COMPUTACAO).build();

    private static Disciplina OPT2 = Disciplina.builder().nome("Optativa 2").qtdCreditos(4).semestre(SEMESTRE_7).areaConhecimento(FLEXIBILIZACAO).horarios(new Horario[]{SEG1, QUI1}).build();
    private static Disciplina PS2 = Disciplina.builder().nome("Processo de Software 2").prerequisito(PS1).qtdCreditos(4).semestre(SEMESTRE_7).areaConhecimento(TECNOLOGIAS_COMPUTACAO).horarios(new Horario[]{SEG2,QUA1}).build();
    private static Disciplina DW = Disciplina.builder().nome("Desenv Web.").qtdCreditos(4).prerequisito(PS1).semestre(SEMESTRE_7).areaConhecimento(TECNOLOGIAS_COMPUTACAO).horarios(new Horario[]{TER1, TER2}).build();
    private static Disciplina CG = Disciplina.builder().nome("Computação Gráfica").prerequisito(AED).qtdCreditos(4).semestre(SEMESTRE_7).areaConhecimento(TECNOLOGIAS_COMPUTACAO).horarios(new Horario[]{QUA2, SEX1}).build();
    private static Disciplina IA = Disciplina.builder().nome("Inteligencia Artificial").qtdCreditos(4).prerequisito(TDG).semestre(SEMESTRE_7).areaConhecimento(TECNOLOGIAS_COMPUTACAO).horarios(new Horario[]{QUI2, SEX2}).build();

    private static Disciplina TCC1 = Disciplina.builder().nome("TCC 1").qtdCreditos(4).semestre(SEMESTRE_8).areaConhecimento(CONCLUSAO_CURSO).horarios(new Horario[]{SEG1, SEX1}).build();
    private static Disciplina OPT3 = Disciplina.builder().nome("Optativa 3").qtdCreditos(4).semestre(SEMESTRE_8).areaConhecimento(FLEXIBILIZACAO).horarios(new Horario[]{SEG2, QUI2}).build();
    private static Disciplina OPT4 = Disciplina.builder().nome("Optativa 4").qtdCreditos(4).semestre(SEMESTRE_8).areaConhecimento(FLEXIBILIZACAO).horarios(new Horario[]{QUA1, SEX2}).build();
    private static Disciplina LEI = Disciplina.builder().nome("Legislação em Informatica").qtdCreditos(2).semestre(SEMESTRE_8).areaConhecimento(CONTEXTO_SOCIAL_PROFISIONAL).horarios(new Horario[]{TER1, null}).build();
    private static Disciplina EEI = Disciplina.builder().nome("Empreendedor em Infomrmática").qtdCreditos(2).semestre(SEMESTRE_8).areaConhecimento(CONTEXTO_SOCIAL_PROFISIONAL).horarios(new Horario[]{TER2, null}).build();
    private static Disciplina SM = Disciplina.builder().nome("Sistenas Multimidia").prerequisito(CG).qtdCreditos(4).semestre(SEMESTRE_8).areaConhecimento(TECNOLOGIAS_COMPUTACAO).horarios(new Horario[]{QUA2, QUI1}).build();

    private static Disciplina TCC2 = Disciplina.builder().nome("TCC 2").prerequisito(TCC1).qtdCreditos(30).semestre(SEMESTRE_9).areaConhecimento(CONCLUSAO_CURSO).horarios(new Horario[]{QUA1, SEX1}).build();

    public static List<Disciplina> getDisplinas() {
        if (displinas.isEmpty()) {
            displinas.add(CP);
            displinas.add(IC);
            displinas.add(UCP);
            displinas.add(FMC);
            displinas.add(PC);
            displinas.add(EF1);
            displinas.add(AC);
            displinas.add(OEG);
            displinas.add(LC);
            displinas.add(ALC);
            displinas.add(POO1);
            displinas.add(EF2);
            displinas.add(SO);
            displinas.add(EST);
            displinas.add(TDC);
            displinas.add(POO2);
            displinas.add(AED);
            displinas.add(PCD);
            displinas.add(MQ);
            displinas.add(LF);
            displinas.add(LDP);
            displinas.add(TDG);
            displinas.add(DSC);
            displinas.add(RDC);
            displinas.add(BD1);
            displinas.add(COP);
            displinas.add(EDS);
            displinas.add(DACD);
            displinas.add(CO);
            displinas.add(OPT1);
            displinas.add(BD2);
            displinas.add(PS1);
            displinas.add(SD);
            displinas.add(OPT2);
            displinas.add(PS2);
            displinas.add(DW);
            displinas.add(CG);
            displinas.add(IA);
            displinas.add(TCC1);
            displinas.add(OPT3);
            displinas.add(OPT4);
            displinas.add(LEI);
            displinas.add(EEI);
            displinas.add(SM);
            displinas.add(TCC2);
        }
        return displinas;
    }

    public static List<Disciplina> getDisplinasAprovadas() {
        if (aprovadas.isEmpty()) {
            aprovadas.add(CP);
            aprovadas.add(IC);
            aprovadas.add(UCP);
            aprovadas.add(FMC);
            aprovadas.add(PC);
            aprovadas.add(EF1);
            aprovadas.add(AC);
            aprovadas.add(OEG);
            aprovadas.add(LC);
            aprovadas.add(ALC);
            aprovadas.add(POO1);
            aprovadas.add(EF2);
            aprovadas.add(SO);
            aprovadas.add(EST);
            aprovadas.add(TDC);
            aprovadas.add(POO2);
            aprovadas.add(AED);
            aprovadas.add(PCD);
            aprovadas.add(MQ);
            aprovadas.add(LF);
            aprovadas.add(LDP);
            aprovadas.add(TDG);
            aprovadas.add(DSC);
            aprovadas.add(RDC);
            aprovadas.add(BD1);
            aprovadas.add(COP);
            aprovadas.add(EDS);
            aprovadas.add(DACD);
            aprovadas.add(CO);
            aprovadas.add(OPT1);
            aprovadas.add(OPT2);
            aprovadas.add(PS1);
            aprovadas.add(SD);
            /**ADD DE TESTES**/
            aprovadas.add(DW);
            aprovadas.add(IA);
            aprovadas.add(LEI);
            aprovadas.add(EEI);
            aprovadas.add(BD2);
            aprovadas.add(CG);
            aprovadas.add(PS2);
            aprovadas.add(TCC1);
        }
        return aprovadas;
    }
}


