public class Application {
    public static void main(String[] args) {
        callMultiTaskManager();
        callLogicVerifier();
    }
    
    private static void callMultiTaskManager() {
        MultiTaskManager manager = new MultiTaskManager();
        manager.findLongestJavaWord();
        manager.selectMacOsMenuItem();
        manager.calculateSchoolGrades();
        manager.countWarAndPeaceUniques();
        manager.showErrorMessage();
        manager.syncCloudStorage();
        manager.restoreBackupData();
        manager.pauseAriaDownload();
        manager.resetMiVacuum();
        manager.writeToFlashDrive();
        manager.convertTemperature();
        manager.inputMathExpression();
        manager.determineRaceWinner();
        manager.findBookByAuthor();
        System.out.println();
    }

    private static void callLogicVerifier() {
        LogicVerifier logicVerifier = new LogicVerifier();
        System.out.println(logicVerifier.shouldProgramContinue());
        System.out.println(logicVerifier.hasUniqueDigits());
        System.out.println(logicVerifier.isLetterInput());
        System.out.println(logicVerifier.hasEqualDigits());
        System.out.println(logicVerifier.hasMarioAttempts());
        System.out.println(logicVerifier.isEmptyInput());
        System.out.println(logicVerifier.isEvenDiceRoll());
        System.out.println(logicVerifier.isPathValid());
        System.out.println(logicVerifier.isFileExists());
    }
}