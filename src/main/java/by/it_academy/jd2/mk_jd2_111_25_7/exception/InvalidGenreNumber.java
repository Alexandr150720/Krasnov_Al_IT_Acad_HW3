package by.it_academy.jd2.mk_jd2_111_25_7.exception;

public class InvalidGenreNumber extends RuntimeException {

    public InvalidGenreNumber() {
        super("Ошибка: выберите от 3 до 5 жанров.");
    }
}
