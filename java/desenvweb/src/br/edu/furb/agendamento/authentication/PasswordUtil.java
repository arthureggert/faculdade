package br.edu.furb.agendamento.authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import br.edu.furb.agendamento.data.persistent.Usuario;
import br.edu.furb.agendamento.util.date.Dates;

/**
 * Classe utilitária para as funções de Hash
 * 
 */
public final class PasswordUtil {

    public static final long VALIDADE_SENHA = 360 * Dates.MSEC_PER_DAY;

    /**
     * Enumeração com os tipos de algoritmos de Hash suportados
     * 
     */
    public enum HashType {
        SHA1("SHA-1"), SHA256("SHA-256"), MD5("MD5");

        private String name;

        private HashType(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     * Recebe como parâmetro uma String, passa esta String<br>
     * pelo algoritmo de Hash "SHA-256". E retorna um Array de Bytes.
     */
    public static byte[] stringToHash(String toConvert) {
        return stringToHash(toConvert, HashType.SHA256);
    }

    /**
     * Recebe como parâmetro uma String e um tipo de Algoritmo de Hash, passa esta String<br>
     * pelo algoritmo de Hash passado como parâmetro. E retorna um Array de Bytes.
     */
    public static byte[] stringToHash(String toConvert, HashType hashType) {
        try {
            MessageDigest md = MessageDigest.getInstance(hashType.getName());
            md.update(toConvert.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * Recebe como parâmetro um Array de Bytes e o transforma em uma String Hexadecimal
     */
    public static String byteArrayToHexString(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) s.append('0');
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }

    public static boolean validatePassword(Usuario user, String newPassword) {

        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "12234567890";
        String carEspec = "`~!@#$%^&*()-_=+[{]}\\|;:'<,>.?/";
        boolean possuiLetra = false;
        boolean possuiNumero = false;
        boolean possuiCarEspec = false;

        //Verifica se a senha possui ao menos 8 caracteres
        if (newPassword.length() < 8) return false;

        //Verifica se nao e usada nenhuma informacao do cadastro na senha
        if (newPassword.indexOf(user.getLogin()) > 0 || user.getLogin().indexOf(newPassword) > 0) return false;
        if (newPassword.indexOf(user.getNome()) > 0 || user.getNome().indexOf(newPassword) > 0) return false;
        if (newPassword.indexOf(user.getEndereco()) > 0 || user.getEndereco().indexOf(newPassword) > 0) return false;
        if (newPassword.indexOf(user.getCpf()) > 0 || user.getCpf().indexOf(newPassword) > 0) return false;

        //Verifica se a nova senha possui alguma letra
        for (int i = 0; i < letras.length(); i++) {
            if (newPassword.toUpperCase().indexOf(letras.charAt(i)) > 0) {
                possuiLetra = true;
            }
        }

        //Verifica se a nova senha possui algum numero
        for (int j = 0; j < numeros.length(); j++) {
            if (newPassword.toUpperCase().indexOf(numeros.charAt(j)) > 0) {
                possuiNumero = true;
            }
        }

        //Verifica se a senha possui algum caractere especial
        for (int k = 0; k < carEspec.length(); k++) {
            if (newPassword.toUpperCase().indexOf(carEspec.charAt(k)) > 0) {
                possuiCarEspec = true;
            }
        }

        if (!possuiLetra || !possuiNumero || !possuiCarEspec) return false;

        user.setValidade(new Date(System.currentTimeMillis() + VALIDADE_SENHA));
        return false;
    }

    public boolean unblockUser(Usuario user) {
        user.setBloqueado(true);
        return true;
    }

}
