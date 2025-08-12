class BooleanMethods {
    public boolean shouldProgramContinue() {
        System.out.print(MethodNameHelper.getCurrent() + 
                "() -> программа выполняется далее или завершается? ");
        return true;
    }
    
    public boolean hasUniqueDigits() {
        System.out.print(MethodNameHelper.getCurrent() + 
                "() -> последовательность содержит уникальную цифру? ");
        return false;
    }
    
    public boolean isLetter() {
        System.out.print(MethodNameHelper.getCurrent() + 
                "() -> пользователь ввел букву или что-то другое? ");
        return true;
    }
    
    public boolean hasEqualDigits() {
        System.out.print(MethodNameHelper.getCurrent() + 
                "() -> в проверяемых числах есть равные цифры? ");
        return false;
    }
    
    public boolean hasAttempts() {
        System.out.print(MethodNameHelper.getCurrent() + 
                "() -> в игре \"Марио\" остались попытки? ");
        return true;
    }
    
    public boolean isEmpty() {
        System.out.print(MethodNameHelper.getCurrent() + 
                "() -> пользователь ввёл пустую строку или из одних пробелов? ");
        return false;
    }
    
    public boolean isEvenDiceRoll() {
        System.out.print(MethodNameHelper.getCurrent() + 
                "() -> на кубике выпало четное число? ");
        return true;
    }
    
    public boolean isValidPath() {
        System.out.print(MethodNameHelper.getCurrent() + 
                "() -> путь до файла на ssd действительный? ");
        return false;
    }
    
    public boolean isExistsFile() {
        System.out.print(MethodNameHelper.getCurrent() + 
                "() -> файл по указанному адресу существует? ");
        return true;
    }
}