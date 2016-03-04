#include <iostream>
#include <sstream>
#include <stdlib.h>
#include "L131105EMontadoras.h"
#include "FilaCircular.cpp"

using namespace std;

FilaCircular<string> *filaNomes = NULL;
FilaCircular<L131105Montadoras> *filaMontadoras = NULL;
FilaCircular<int> *filaInteiros =  NULL;

string pedeConsole(string);
string tiposListas();
int quantidadeElementosFila(string);
int tamanhoFila(string);
int totalListas();
void imprimeMenu1();
void imprimeMenu2(string);
void finaliza();
void criaFila(string);
void destroiFila(string);
void inserir(string);
void imprime(string);
void excluir(string);

int main(void) {
	cout << "L1311E04 - Arthur Henrique Eggert \n";
	imprimeMenu1();
}
void imprimeMenu1() {
	cout << "1 - fila de nomes \n"
			<< "2 - fila de inteiros \n"
			<< "3 - fila de montadoras \n"
			<< "9 - finaliza\n"
			<< "Filas existentes: " << totalListas()
			<< "\nTipos de filas existentes: " << tiposListas();
	switch (atoi(pedeConsole("").c_str())) {
	case 1:
		imprimeMenu2("String");
		break;
	case 2:
		imprimeMenu2("Inteiro");
		break;
	case 3:
		imprimeMenu2("Montadoras");
		break;
	case 9:
		finaliza();
		break;
	default:
		cout << "Valor Informado Inválido" << endl;
		imprimeMenu1();
		break;
	}
}

void imprimeMenu2(string tipo){
	cout << "Tipo da fila: " << tipo
			<< "\nTotal de Elemento: " << quantidadeElementosFila(tipo)
			<< "\nTamanho da fila: " << tamanhoFila(tipo)
			<< "\n1 - criar fila\n"
			<< "2 - destruir fila\n"
			<< "3 - inserir\n"
			<< "4 - mostrar\n"
			<< "5 - excluir\n"
			<< "9 - retorna ao menu 1" << endl;
	switch (atoi(pedeConsole("").c_str())) {
	case 1:
		criaFila(tipo);
		imprimeMenu2(tipo);
		break;
	case 2:
		destroiFila(tipo);
		imprimeMenu2(tipo);
		break;
	case 3:
		inserir(tipo);
		imprimeMenu2(tipo);
		break;
	case 4:
		imprime(tipo);
		imprimeMenu2(tipo);
		break;
	case 5:
		excluir(tipo);
		imprimeMenu2(tipo);
		break;
	case 9:
		imprimeMenu1();
		break;

	default:
		cout << "Valor Invalido" << endl;
		imprimeMenu2(tipo);
		break;
	}
}

void finaliza(){
	if(filaInteiros == NULL && filaMontadoras == NULL && filaNomes == NULL){
		exit(EXIT_SUCCESS);
	} else {
		cout << "Existem Filas Criadas" << endl;
		imprimeMenu1();
	}
}

string pedeConsole(string msg) {
	cout << msg << endl;
	string retorno;
	cin >> retorno;
	return retorno;
}

void excluir(string tipo){
	if(tipo.compare("String") == 0){
		if(filaNomes != NULL){
			if(!filaNomes->isVazia()){
				filaNomes->retira();
			} else {
				cout << "Fila Vazia" << endl;
			}
		}
		return;
	}
	if(tipo.compare("Inteiro") == 0){
		if(filaInteiros != NULL){
			if(!filaInteiros->isVazia()){
				filaInteiros->retira();
			} else {
				cout << "Fila Vazia" << endl;
			}
		}
		return;
	}
	if(tipo.compare("Montadoras") == 0 ){
		if(filaMontadoras != NULL){
			if(!filaMontadoras->isVazia()){
				filaMontadoras->retira();
			} else {
				cout << "Fila Vazia" << endl;
			}
		}
		return;
	}
}

void imprime(string tipo){
	if(tipo.compare("String") == 0){
		if(filaNomes != NULL){
			filaNomes->imprime();
			return;
		}
	}
	if(tipo.compare("Inteiro") == 0){
		if(filaInteiros != NULL){
			filaInteiros->imprime();
			return;
		}
	}
	if(tipo.compare("Montadoras") == 0 ){
		if(filaMontadoras != NULL){
			filaMontadoras->imprime();
			return;
		}
	}

}
void inserir(string tipo){
	if(tipo.compare("String") == 0){
		if(filaNomes != NULL){
			if(!filaNomes->isCheia()){
				string dado = pedeConsole("Digite um nome");
				filaNomes->insere(dado);
			} else {
				cout << "Fila Cheia" << endl;
			}
		}
		return;
	}
	if(tipo.compare("Inteiro") == 0){
		if(filaInteiros != NULL){
			if(!filaInteiros->isCheia()){
				int dado = atoi(pedeConsole("Digite um inteiro").c_str());
				filaInteiros->insere(dado);
			} else {
				cout << "Fila Cheia" << endl;
			}
		}
		return;
	}
	if(tipo.compare("Montadoras") == 0 ){
		if(filaMontadoras != NULL){
			if(!filaMontadoras->isCheia()){
				try {
					L131105Montadoras dado = valueOf(pedeConsole("Digite uma Montadora").c_str());
					filaMontadoras->insere(dado);
				} catch (exception e) {
					cout << "Montadora Inválida" << endl;
				}
			} else {
				cout << "Fila Cheia" << endl;
			}
		}
		return;
	}
}

void destroiFila(string tipo){
	if(tipo.compare("String") == 0){
		if(filaNomes->isVazia()){
			filaNomes = NULL;
			return;
		}
	}
	if(tipo.compare("Inteiro") == 0){
		if(filaInteiros->isVazia()){
			filaInteiros = NULL;
			return;
		}
	}
	if(tipo.compare("Montadoras") == 0 ){
		if(filaMontadoras->isVazia()){
			filaMontadoras = NULL;
			return;
		}
	}
	cout << "Fila " << tipo << " com elementos criados" << endl;
}

void criaFila(string tipo){
	if(tipo.compare("String") == 0){
		if(filaNomes == NULL){
			filaNomes = new FilaCircular<string>(atoi(pedeConsole("Informe o tamanho: ").c_str()));
			return;
		}
	}
	if(tipo.compare("Inteiro") == 0){
		if(filaInteiros == NULL){
			filaInteiros = new FilaCircular<int>(atoi(pedeConsole("Informe o tamanho: ").c_str()));
			return;
		}
	}
	if(tipo.compare("Montadoras") == 0 ){
		if(filaMontadoras == NULL){
			filaMontadoras = new FilaCircular<L131105Montadoras>(atoi(pedeConsole("Informe o tamanho: ").c_str()));
			return;
		}
	}
	cout << "Tipo " << tipo << " já criada" << endl;
}

int tamanhoFila(string tipo) {
	int tamanhoFila = 0;
	if(tipo.compare("String") == 0) {
		if(filaNomes != NULL){
			tamanhoFila = filaNomes->getTamanho();
		}
	}
	if(tipo.compare("Inteiro") == 0) {
		if(filaInteiros != NULL){
			tamanhoFila = filaInteiros->getTamanho();
		}
	}
	if(tipo.compare("Montadoras") == 0) {
		if(filaMontadoras != NULL) {
			tamanhoFila = filaMontadoras->getTamanho();
		}
	}
	return tamanhoFila;
}

int totalListas() {
	int totalListas = 0;
	if (filaInteiros != NULL){
		totalListas+=1;
	}
	if (filaMontadoras != NULL){
		totalListas+=1;
	}
	if (filaNomes != NULL){
		totalListas+=1;
	}
	return totalListas;
}

string tiposListas() {
	string filas = "";
	if (filaNomes != NULL){
		filas+="Nomes ";
	}
	if (filaInteiros != NULL){
		filas+="Inteiros ";
	}
	if (filaMontadoras != NULL){
		filas+="Montadoras ";
	}
	if (filas.length() == 0){
		filas = "Nenhuma";
	}
	return filas;
}

int quantidadeElementosFila(string tipo) {
	int qtdElementos = 0;
	if(tipo.compare("String") == 0) {
		if(filaNomes != NULL){
			qtdElementos = filaNomes->getQtdElemento();
		}
	}
	if(tipo.compare("Inteiro") == 0) {
		if(filaInteiros != NULL){
			qtdElementos = filaInteiros->getQtdElemento();
		}
	}
	if(tipo.compare("Montadoras") == 0) {
		if(filaMontadoras != NULL) {
			qtdElementos = filaMontadoras->getQtdElemento();
		}
	}
	return qtdElementos;
}
