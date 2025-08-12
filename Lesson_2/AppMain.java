public class AppMain {
    public static void main(String[] args) {
        doMultiTaskManager();
        doLogicVerifier();
    }
    
    private static void doMultiTaskManager() {
        MultiTaskManager manager = new MultiTaskManager();
        manager.findLongestWord();
        manager.selectMacOsMenuItem();
        manager.calculateGPA();
        manager.countUniques();
        manager.showErrorMessage();
        manager.syncCloudStorage();
        manager.restoreBackupData();
        manager.pauseDownload();
        manager.resetMiVacuum();
        manager.writeToStorage();
        manager.convertTemperature();
        manager.inputMathExpression();
        manager.determineRaceWinner();
        manager.findBookByAuthor();
        System.out.println();
    }

    private static void doLogicVerifier() {
        LogicVerifier logicVerifier = new LogicVerifier();
        System.out.println(logicVerifier.shouldProgramContinue());
        System.out.println(logicVerifier.hasUniqueDigits());
        System.out.println(logicVerifier.isLetter());
        System.out.println(logicVerifier.hasEqualDigits());
        System.out.println(logicVerifier.hasAttempts());
        System.out.println(logicVerifier.isEmpty());
        System.out.println(logicVerifier.isEvenDiceRoll());
        System.out.println(logicVerifier.isValidPath());
        System.out.println(logicVerifier.isExistsFile());
    }
}