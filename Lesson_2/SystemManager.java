class SystemManager {
    public void selectMacOsMenuItem() {
        System.out.println(getCurrentMethodName() + 
                "() -> выбрать пункт меню в текстовом редакторе на macOS");
    }
    
    public void showErrorMessage() {
        System.out.println(getCurrentMethodName() + 
                "() -> вывести сообщение об ошибке");
    }
    
    public void resetMiVacuum() {
        System.out.println(getCurrentMethodName() + 
                "() -> сбросить настройки до заводских для пылесоса Mi");
    }
    
    public void writeToFlashDrive() {
        System.out.println(getCurrentMethodName() + 
                "() -> записать содержимое в файл по указанному пути на флешку");
    }
    
    private static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}