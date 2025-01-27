package pages;



public class ThreadLocalVariables {

    public static ThreadLocal<String> candNameInScope = new ThreadLocal<String>();
    public static ThreadLocal<String> dynamicEmailFromEventUtility = new ThreadLocal<String>();
    public static ThreadLocal<String> dynamicUUIDFromEventUtility = new ThreadLocal<String>();
    public static ThreadLocal<String> claimedEmailId = new ThreadLocal<String>();
    public static ThreadLocal<String> claimedUUID = new ThreadLocal<String>();
    public static ThreadLocal<String> verificationCode = new ThreadLocal<String>();
    public static ThreadLocal<String> emailConsumedInNewCandSmoke = new ThreadLocal<String>();
    public static ThreadLocal<String> visibleCertification = new ThreadLocal<String>();
    public static ThreadLocal<String> certificationData = new ThreadLocal<String>();
    public static ThreadLocal<String> nameOfVisibleClientFromClientGrid = new ThreadLocal<>();
    public static ThreadLocal<String> nameOfVisibleCompanyFromClientGrid = new ThreadLocal<>();
    public static ThreadLocal<String> newLastNameUsedForClientCreationInAdmin = new ThreadLocal<>();
    public static ThreadLocal<String> newFirstNameUsedForClientCreationInAdmin = new ThreadLocal<>();
    public static ThreadLocal<String> nameOfFirstVisibleClientFromJobsGrid = new ThreadLocal<>();
    public static ThreadLocal<String> skillsDataEditedFOrJobPost = new ThreadLocal<>();
    public static ThreadLocal<String> jobTitleEnteredForJob = new ThreadLocal<>();
    public static ThreadLocal<String> jobSummaryEditedForJobPost = new ThreadLocal<>();
    public static ThreadLocal<String> jobRateEditedForJobPost = new ThreadLocal<>();
    public static ThreadLocal<String> jobDatesEditedForJobPost = new ThreadLocal<>();
    public static ThreadLocal<String> jobCertificateEdited = new ThreadLocal<>();
    public static ThreadLocal<String> industryEditedForJobPost = new ThreadLocal<>();
    public static ThreadLocal<String> aboutCompanyEditedForJobPost = new ThreadLocal<>();
    public static ThreadLocal<String> nameOfLastCand = new ThreadLocal<>();
    public static ThreadLocal<String> nameOfFirstCand = new ThreadLocal<>();
    public static ThreadLocal<String> uuidOfClientInTestScope = new ThreadLocal<>();
    public static ThreadLocal<String> approvedClientUUID = new ThreadLocal<>();
    public static ThreadLocal<String> EmailFetchedFromMainProfile = new ThreadLocal<>();
    public static ThreadLocal<String> firstNameForClient = new ThreadLocal<>();
    public static ThreadLocal<String> lastNameForClient = new ThreadLocal<>();
    public static ThreadLocal<String> clientEmailOnTheFly = new ThreadLocal<>();
    public static ThreadLocal<String> firstVisibleTitle = new ThreadLocal<>();
    public static ThreadLocal<String> uniqueFirstName = new ThreadLocal<>();
    public static ThreadLocal<String> uniqueLastName = new ThreadLocal<>();
    public static ThreadLocal<String> visibleFeaturedCand = new ThreadLocal<>();
    public static ThreadLocal<String> featuredCandSkill = new ThreadLocal<>();
    public static ThreadLocal<String> locationEnteredForJob = new ThreadLocal<>();
    public static ThreadLocal<String> nameOfTheCandidate = new ThreadLocal<>();
    public static ThreadLocal<String> candidateCount = new ThreadLocal<>();
    public static ThreadLocal<String> nameOfVisibleClientFromJobsGrid_ = new ThreadLocal<>();
    public static ThreadLocal<String> nameOfVisibleTitleFromJobsGrid = new ThreadLocal<>();
    public static ThreadLocal<String> nameOfFirstJobTitleFromJobsGrid = new ThreadLocal<>();
    public static ThreadLocal<String> nameOfVisibleClientFromJobsGrid = new ThreadLocal<>();
    public static ThreadLocal<String> candidateProfileName = new ThreadLocal<>();
    public static ThreadLocal<String> certificationEntered = new ThreadLocal<>();
    public static ThreadLocal<String> universityEntered = new ThreadLocal<>();
    public static ThreadLocal<String> majorEntered = new ThreadLocal<>();
    public static ThreadLocal<String> newFirstNameUsedForCandidateCreationInAdmin = new ThreadLocal<>();
    public static ThreadLocal<String> newLastNameUsedForCandidateCreationInAdmin = new ThreadLocal<>();
    public static ThreadLocal<String> candidateNameSecurityLogin7 = new ThreadLocal<>();
    public static ThreadLocal<String> newStaticProfileName = new ThreadLocal<>();
    public static ThreadLocal<String> staticProfilelinkText = new ThreadLocal<>();
    public static ThreadLocal<String> staticProfileDataAsSaved = new ThreadLocal<>();
    public static ThreadLocal<String> locationEntered = new ThreadLocal<>();
    public static ThreadLocal<String> summaryData = new ThreadLocal<>();
    public static ThreadLocal<String> companyName = new ThreadLocal<>();
    public static ThreadLocal<String> nameOfVisibleCandidateFromTalentGrid = new ThreadLocal<>();
    public static ThreadLocal<String> firstName = new ThreadLocal<>();
    public static ThreadLocal<String> lastName = new ThreadLocal<>();
    public static ThreadLocal<String> uuidFromCandidateProfile = new ThreadLocal<>();
    public static ThreadLocal<String> UUID_inTestScope = new ThreadLocal<>();
    public static ThreadLocal<String> universityData = new ThreadLocal<>();
    public static ThreadLocal<String> jobTitleEntered = new ThreadLocal<>();
    public static ThreadLocal<String> jobTitlesData = new ThreadLocal<>();
    public static ThreadLocal<String> jobsUUID = new ThreadLocal<>();
    public static ThreadLocal<String> approvedJobsUUID = new ThreadLocal<>();
    public static ThreadLocal<String> jobTitleOfClientJobPost = new ThreadLocal<>();
    public static ThreadLocal<String> industriesData = new ThreadLocal<>();
    public static ThreadLocal<String> skillsData = new ThreadLocal<>();
    public static ThreadLocal<String> locationClientJob = new ThreadLocal<>();
    public static ThreadLocal<String> jobSummaryAsEnteredByClient = new ThreadLocal<>();
    public static ThreadLocal<String> skillsAsEnteredByClient = new ThreadLocal<>();
    public static ThreadLocal<String> dateAsEnteredByClient = new ThreadLocal<>();
    public static ThreadLocal<String> aboutAsEnteredByClient = new ThreadLocal<>();
    public static ThreadLocal<String> rateAsEnteredByClient = new ThreadLocal<>();
    public static ThreadLocal<String> number_of_cand_rated = new ThreadLocal<>();
    public static ThreadLocal<String> likedCandName = new ThreadLocal<>();
    public static ThreadLocal<String> fNameClient = new ThreadLocal<>();
    public static ThreadLocal<String> lNameClient = new ThreadLocal<>();
    public static ThreadLocal<String> clientRegisteredEmail = new ThreadLocal<>();
    public static ThreadLocal<String> correctZipCodeNumber = new ThreadLocal<>();
    public static ThreadLocal<String> jobTitleSaved = new ThreadLocal<>();
    public static ThreadLocal<String> emailAddressSaved = new ThreadLocal<>();
    public static ThreadLocal<String> jobPostNum = new ThreadLocal<>();

    //below are the variables that are specific to a thread.
    private static ThreadLocalVariables instance = new ThreadLocalVariables();

    public static ThreadLocalVariables getInstance() {
        return instance;
    }

    //This is method to set the variable value, takes variable name and variable value
    public String setThreadLocalStringVar(ThreadLocal<String> varName, String varValue) {
        varName.set(varValue);
        return String.valueOf(varName);
    }

    //This is method to call ThreadLocal variable, takes variable name
    public String getThreadLocalStringVar(String varName) {
        return varName;
    }


}