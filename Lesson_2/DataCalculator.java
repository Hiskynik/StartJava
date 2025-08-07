class DataCalculator {
    public void calculateSchoolGrades() {
        System.out.println(getCurrentMethodName() + 
                "() -> вычислить среднее значение оценок в школе №1234");
    }
    
    public void syncCloudStorage() {
        System.out.println(getCurrentMethodName() + 
                "() -> синхронизировать данные с облачным хранилищем");
    }
    
    public void restoreBackupData() {
        System.out.println(getCurrentMethodName() + 
                "() -> восстановить данные из резервной копии от 11.03.2024");
    }
    
    public void pauseAriaDownload() {
        System.out.println(getCurrentMethodName() + 
                "() -> приостановить загрузку mp3-файла группы \"Ария\"");
    }
    
    public void convertTemperature() {
        System.out.println(getCurrentMethodName() + 
                "() -> преобразовать температуру из Цельсия в Фаренгейт");
    }
    
    public void inputMathExpression() {
        System.out.println(getCurrentMethodName() + 
                "() -> ввести математическое выражение с тремя аргументами");
    }
    
    public void determineRaceWinner() {
        System.out.println(getCurrentMethodName() + 
                "() -> выявить победителя среди гонщиков игры \"Need For Speed\"");
    }
    
    private static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}