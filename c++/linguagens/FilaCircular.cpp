#include <iostream>

using namespace std;

template <class T>
class FilaCircular {
public:
	FilaCircular(int tamanho){
		this->inicio = 0;
		this->fim = 0;
		this->tamanho = tamanho;
		this->qtdElemento = 0;
		this->armazen = new T[tamanho];
	}
	void insere(T dado){
		this->armazen[this->fim] = dado;
		this->fim = (this->fim +1) % this->tamanho;
		this->qtdElemento++;
	}

	void retira(){
		cout << "Excluíndo: " << this->armazen[this->inicio] << "\n";
		this->inicio = (this->inicio + 1) % this->tamanho;
		this->qtdElemento--;
	}

	bool possui(T dado){
		for (int var = 0; var < qtdElemento; var++) {
			if (this->armazen[var] == dado) {
				return true;
			}
		}
		return false;
	}

	void imprime(){
		cout << this->armazen[this->inicio];
	}

	bool isVazia(){
		return this->qtdElemento == 0;
	}

	bool isCheia(){
		return this->qtdElemento == this->tamanho;
	}

	int getQtdElemento(){
		return this->qtdElemento;
	}

	int getTamanho(){
		return this->tamanho;
	}

private:
	int tamanho;
	int inicio;
	int fim;
	int qtdElemento;
	T* armazen;
};
