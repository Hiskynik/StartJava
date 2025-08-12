public class AppMain {
    public static void main(String[] args) {
        doNonBooleanMethods();
        doBooleanMethods();
    }
    
    private static void doNonBooleanMethods() {
        NonBooleanMethods method1 = new NonBooleanMethods();
        method1.findLongestWord();
        method1.selectMacOsMenuItem();
        method1.calculateGpa();
        method1.countUniques();
        method1.showErrorMessage();
        method1.syncCloudStorage();
        method1.restoreBackupData();
        method1.pauseDownload();
        method1.resetMiVacuum();
        method1.writeToFile();
        method1.convertTemperature();
        method1.inputMathExpression();
        method1.determineRaceWinner();
        method1.findBookByAuthor();
        System.out.println();
    }

    private static void doBooleanMethods() {
        BooleanMethods method2 = new BooleanMethods();
        System.out.println(method2.shouldProgramContinue());
        System.out.println(method2.hasUniqueDigits());
        System.out.println(method2.isLetter());
        System.out.println(method2.hasEqualDigits());
        System.out.println(method2.hasAttempts());
        System.out.println(method2.isEmpty());
        System.out.println(method2.isEvenDiceRoll());
        System.out.println(method2.isValidPath());
        System.out.println(method2.isExistsFile());
    }
}