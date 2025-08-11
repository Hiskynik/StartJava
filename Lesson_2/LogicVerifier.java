class LogicVerifier {
    public boolean shouldProgramContinue() {
        System.out.print(MethodNameHelper.getCurrentMethodName() + 
                "() -> программа выполняется далее или завершается? ");
        return true;
    }
    
    public boolean hasUniqueDigits() {
        System.out.print(MethodNameHelper.getCurrentMethodName() + 
                "() -> последовательность содержит уникальную цифру? ");
        return false;
    }
    
    public boolean isLetterInput() {
        System.out.print(MethodNameHelper.getCurrentMethodName() + 
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }
    
    public boolean hasEqualDigits() {
        System.out.print(MethodNameHelper.getCurrentMethodName() + 
                "() -> в проверяемых числах есть равные цифры? ");
        return false;
    }
    
    public boolean hasMarioAttempts() {
        System.out.print(MethodNameHelper.getCurrentMethodName() + 
                "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }
    
    public boolean isEmptyInput() {
        System.out.print(MethodNameHelper.getCurrentMethodName() + 
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }
    
    public boolean isEvenDiceRoll() {
        System.out.print(MethodNameHelper.getCurrentMethodName() + 
                "() -> на кубике выпало четное число? ");
        return true;
    }
    
    public boolean isPathValid() {
        System.out.print(MethodNameHelper.getCurrentMethodName() + 
                "() -> путь до файла на ssd действительный? ");
        return false;
    }
    
    public boolean isFileExists() {
        System.out.print(MethodNameHelper.getCurrentMethodName() + 
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}