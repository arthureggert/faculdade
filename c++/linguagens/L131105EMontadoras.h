#include <exception>
#include <iostream>
#include <sstream>
#include <stdlib.h>
#include <string.h>

using namespace std;

enum L131105Montadoras {
	CHEVROLET,
	CITROEN,
	FIAT,
	FORD,
	HONDA,
	HYUNDAI,
	KIA,
	MITSUBISHI,
	NISSAN,
	PEUGEOT,
	RENAULT,
	TOYOTA,
	VOLKSWAGEN
};

struct enumtypes {
	L131105Montadoras montadora;
	string tipo;
};

struct enumtypes array[] = {
		{CHEVROLET, "CHEVROLET"},
		{CITROEN, "CITROEN"},
		{FIAT, "FIAT"},
		{FORD, "FORD"},
		{HONDA, "HONDA"},
		{HYUNDAI, "HYUNDAI"},
		{KIA, "KIA"},
		{MITSUBISHI, "MITSUBISHI"},
		{NISSAN, "NISSAN"},
		{PEUGEOT, "PEUGEOT"},
		{RENAULT, "RENAULT"},
		{TOYOTA, "TOYOTA"},
		{VOLKSWAGEN, "VOLKSWAGEN"}
};

L131105Montadoras valueOf(const char* dado) throw (exception) {
	const int tam = sizeof(array) / sizeof(array[0]);
	for(int i = 0; i < tam; i++){
		if(strcmp(array[i].tipo.c_str(), dado) == 0)
			return array[i].montadora;
	}
	throw exception();
};

