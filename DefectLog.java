package database;

public class DefectLog extends Log {
    public String projTitle;
    public String defectName;
    public String category;
    public String defectDescription;
    public String status;
    public String stepInjected;
    public String stepResolved;

    // changed to empty strings -AK
    public DefectLog(){
        this.projTitle = "";
        this.defectName = "";
        this.category = "";
        this.defectDescription = "";
        this.status = "";
        this.stepInjected = "";
        this.stepResolved = "";
    }

    public DefectLog(String projTitle, String defectName, String category, String defectDescription, String status, String stepInjected, String stepResolved){
        this.projTitle = projTitle;
        this.defectName = defectName;
        this.category = category;
        this.defectDescription = defectDescription;
        this.status = status;
        this.stepInjected = stepInjected;
        this.stepResolved = stepResolved;
    }


    public DefectLog editLog(String projTitle, String defectName, String category, String defectDescription, String status, String stepInjected, String stepResolved){
        DefectLog updatedLog = new DefectLog(projTitle, defectName, category, defectDescription, status, stepInjected, stepResolved);
        return updatedLog;
    }

    public String returnProjectTitle() {
        return projTitle;
    }

    public String returnDefectName() {
        return defectName;
    }

    public String returnCategory() {
        return category;
    }

    public String returnDefectDescription() {
        return defectDescription;
    }

    public String returnStatus() {
        return status;
    }

    public String returnStepInjected() {
        return stepInjected;
    }

    public String returnStepResolved() {
        return stepResolved;
    }
}
