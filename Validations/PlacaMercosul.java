    public static boolean validarPlaca(String placa) {
        boolean placaValida = true;

        String placaLimpa = placa.replace("-", "");

        if (placaLimpa.length() > 0) {
            if (placaLimpa.length() < 7) {
                placaValida = false;
            } else {
                if (!placaLimpa.matches("[a-zA-Z]{3}[0-9][a-zA-Z][0-9]{2}")) {
                    placaValida = false;
                }
            }
        }
        return placaValida;
    }