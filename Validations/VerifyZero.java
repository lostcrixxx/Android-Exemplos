    /**
     * Dia menor que 10, adiciona o zero na frente
     * @param num day
     * @return Dia com zero na frente
     */
    public static String verifyZero(int num) {
        String result = "";
        switch (num){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                result = "0" + num;
                break;
            default:
                result = String.valueOf(num);
                break;
        }
        return  result;
    }