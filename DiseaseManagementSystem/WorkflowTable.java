
package DiseaseManagementSystem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Workflow Table that will contain the corresponding IDs of all applicants'
 *     forms.
 */
public class WorkflowTable {

    /**
     * The list of IDs for all Infected User Data forms that are waiting to be
     *     reviewed.
     */
    private Queue<InfectedUserData> reviewQueue;

    /**
     * The list of IDs for all Infected User Data forms that are waiting to be
     *     approved.
     */
    private Queue<InfectedUserData> approvalQueue;

    /**
     * Helper method that constructs the Workflow Table with its lists of
     *     IDs for all forms to be checked for review and approval.
     */
    WorkflowTable() {
        this.reviewQueue = new LinkedList<>();
        this.approvalQueue = new LinkedList<>();
    }

    /**
     * Creates the Workflow Table with its lists of IDs for all forms to be
     *     checked for review and approval.
     * 
     * @return the Workflow Table withs its lists of IDs for all forms to be
     *     checked for review and approval.
     */
    public static WorkflowTable createWorkflowTable() {
        return new WorkflowTable();   
    }

    /**
     * Adds the formID of an applicant's InfectedUserData to the end of the
     *     reviewIDQueue.
     * 
     * @param formID for the formID of the applicant's InfectedUserData.
     * @return true if the formID was successfully added to the end of the
     *     reviewIDQueue, otherwise return false.
     */
    public boolean addReviewForm(InfectedUserData form) {

        if (form == null) {
            return false;
        }

        if (reviewQueue.add(form) == true) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Returns the formID of an applicant's InfectedUserData to be reviewed
     *     if it exitsts in the reviewIDQueue.
     * 
     * @return the formID of the applicant's InfectedUserData if it was found
     *     in the reviewIDQueue; return -1 if the reviewIDQueue was not
     *     initialized; return 0 if the reviewIDQueue was empty.
     */
    public InfectedUserData getNextReviewForm() {

        InfectedUserData placeholder = new InfectedUserData(null, null, null, null, 0, false, null);

        if (!reviewQueue.isEmpty()) {
            // needs to be changed to properly implement queue functionality.
            // we actually want to remove the form, not just retrieve it.
            // peek() won't remove the form for us.
            return reviewQueue.poll();
        } else {
            return placeholder;
        }
    }

    /**
     * Adds the formID of an applicant's InfectedUserData to the end of the
     *     approvalIDQueue.
     * 
     * @param formID for the formID of the applicant's InfectedUserData.
     * @return true if the formID was successfully added to the end of the
     *     approvalIDQueue, otherwise return false.
     */
    public boolean addApprovalForm(InfectedUserData form) {
        
        if (form == null) {
            return false;
        }

        if (approvalQueue.add(form)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the formID of an applicant's InfectedUserData to be approved
     *     if it exitsts in the approvalIDQueue.
     * 
     * @return the formID of the applicant's InfectedUserData if it was found
     *     in the approvalIDQueue; return -1 if the approvalIDQueue was not
     *     initialized; return 0 if the approvalIDQueue was empty.
     */
    public InfectedUserData getNextApprovalForm() {

        InfectedUserData placeholder = new InfectedUserData(null, null, null, null, 0, false, null);

        if (!approvalQueue.isEmpty()) {
            return approvalQueue.poll();
        } else {
            return placeholder;
        }

    }

}