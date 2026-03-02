import os
import re
from dataclasses import dataclass

# ============================================================
# OUTPUT ROOT (matches your project structure)
# ============================================================
TEST_JAVA_ROOT = os.path.join("src", "test", "java")

# ============================================================
# DUMMY IDS for dynamic routes (replace later if needed)
# ============================================================
TEST_ID = '"000000000000000000000000"'
TEST_PROJECT_ID = '"69a58f3a326ce82d2a693069"'          # ✅ your real project id
TEST_SCENARIO_ID = '"000000000000000000000000"'
TEST_TASK_ID = '"000000000000000000000000"'
TEST_DEFECT_ID = '"000000000000000000000000"'
TEST_DEV_ID = '"000000000000000000000000"'
TEST_USER_ID = '"66d849960093c94b4cee0381"'             # ✅ your createdBy
TEST_NOTIFICATION_ID = '"000000000000000000000000"'
TEST_SLUG = '"test-slug"'
TEST_MODULE_NAME = '"Header"'

# ============================================================
# Helpers
# ============================================================
def ensure_dir(path: str):
    os.makedirs(path, exist_ok=True)

def write_file(path: str, content: str):
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)

def camel_to_snake(name: str) -> str:
    # "AllTodoTaskListPage" -> "all_todo_task_list_page"
    s1 = re.sub("(.)([A-Z][a-z]+)", r"\1_\2", name)
    s2 = re.sub("([a-z0-9])([A-Z])", r"\1_\2", s1)
    return s2.lower()

def package_key_from_pom(pom_class: str) -> str:
    # ✅ Special-case HomePage to match your existing folder name exactly
    if pom_class == "HomePage":
        return "homepage"  # NOT home_page

    # default
    return camel_to_snake(pom_class)

def package_name_from_pom(pom_class: str) -> str:
    key = package_key_from_pom(pom_class)
    return f"scripts.{key}_scenarios.functional_scenarios"

def dir_from_pom(pom_class: str) -> str:
    key = package_key_from_pom(pom_class)
    return os.path.join(
        TEST_JAVA_ROOT,
        "scripts",
        f"{key}_scenarios",
        "functional_scenarios",
    )

def class_name(scenario_no: str, pom_class: str) -> str:
    return f"AS_{scenario_no}_Open{pom_class}UsingUrl"

# ============================================================
# Model
# ============================================================
@dataclass
class PageTest:
    scenario_no: str
    sheet_name: str
    pom_class: str
    url_expr: str

def make_java(t: PageTest) -> str:
    pkg = package_name_from_pom(t.pom_class)
    cls = class_name(t.scenario_no, t.pom_class)

    # ✅ 100% identical pattern to your sample:
    # - extends OpenClose
    # - reads expected title from Excel (row 1, col 0)
    # - opens URL for that page using driver.get(...)
    # - verifies via POM verify<POJO>Title(expectedTitle)
    return f"""package {pkg};

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.{t.pom_class};

public class {cls} extends OpenClose {{

\t@Test
\tpublic void testOpen{t.pom_class}UsingUrl() throws IOException {{
\t\tString expectedTitle = (String) Excel.getData("{t.sheet_name}", 1, 0);

\t\tdriver.get({t.url_expr});

\t\t{t.pom_class} page = new {t.pom_class}(driver);
\t\tpage.verify{t.pom_class}Title(expectedTitle);
\t}}
}}
"""

# ============================================================
# Define ALL “Open using URL” scenarios (from your pages list)
# ============================================================
tests = [
    # Home
    PageTest("7346", "HomePage", "HomePage", "URL_HOME"),
    PageTest("7347", "HomePage", "HomePage", "URL_HOME_ALT_1"),
    PageTest("7348", "HomePage", "HomePage", "URL_HOME_ALT_2"),

    # Public pages
    PageTest("7349", "ProjectsPage", "ProjectsPage", "URL_PROJECTS"),
    PageTest("7350", "ExploreSolutionsPage", "ExploreSolutionsPage", "URL_EXPLORE_SOLUTIONS"),
    PageTest("7351", "AiSystemsPage", "AiSystemsPage", "URL_AI_SYSTEMS"),
    PageTest("7352", "BlockchainPage", "BlockchainPage", "URL_BLOCKCHAIN"),
    PageTest("7353", "WebAppsPage", "WebAppsPage", "URL_WEB_APPS"),
    PageTest("7354", "QaAutomationPage", "QaAutomationPage", "URL_QA_AUTOMATION"),

    # Auth
    PageTest("7355", "LoginPage", "LoginPage", "URL_LOGIN"),
    PageTest("7356", "RegisterPage", "RegisterPage", "URL_REGISTER"),

    # Static pages
    PageTest("7357", "ContactUsPage", "ContactUsPage", "URL_CONTACT"),
    PageTest("7358", "PrivacyPolicyPage", "PrivacyPolicyPage", "URL_PRIVACY_POLICY"),
    PageTest("7359", "AboutUsPage", "AboutUsPage", "URL_ABOUT_US"),
    PageTest("7360", "CareersPage", "CareersPage", "URL_CAREERS"),

    # Blogs
    PageTest("7361", "AllBlogsPage", "AllBlogsPage", "URL_ALL_BLOGS"),
    PageTest("7362", "SingleBlogPage", "SingleBlogPage", f'URL_SINGLE_BLOG_BASE + {TEST_SLUG} + "/" + {TEST_ID}'),
    PageTest("7363", "UpdateBlogPage", "UpdateBlogPage", f'URL_UPDATE_BLOG_BASE + {TEST_SLUG} + "/" + {TEST_ID}'),

    # Dashboard / Profile
    PageTest("7364", "DashboardPage", "DashboardPage", "URL_DASHBOARD"),
    PageTest("7365", "ProfilePage", "ProfilePage", f"URL_PROFILE_BASE + {TEST_USER_ID}"),
    PageTest("7366", "UpdateProfilePage", "UpdateProfilePage", f"URL_UPDATE_PROFILE_BASE + {TEST_USER_ID}"),

    # Users
    PageTest("7367", "AllUsersPage", "AllUsersPage", "URL_ALL_USERS"),
    PageTest("7368", "SingleUserPage", "SingleUserPage", f"URL_SINGLE_USER_BASE + {TEST_USER_ID}"),

    # Subscriptions
    PageTest("7369", "SubscriptionsPage", "SubscriptionsPage", "URL_ALL_SUBSCRIPTIONS"),

    # Role dashboards
    PageTest("7370", "SuperAdminDashboardPage", "SuperAdminDashboardPage", "URL_SUPER_ADMIN_DASHBOARD"),
    PageTest("7371", "AdminDashboardPage", "AdminDashboardPage", "URL_ADMIN_DASHBOARD"),
    PageTest("7372", "QaDashboardPage", "QaDashboardPage", "URL_QA_DASHBOARD"),
    PageTest("7373", "TestEngineerDashboardPage", "TestEngineerDashboardPage", "URL_TEST_ENGINEER_DASHBOARD"),
    PageTest("7374", "DeveloperDashboardPage", "DeveloperDashboardPage", "URL_DEVELOPER_DASHBOARD"),

    # Projects
    PageTest("7375", "CreateProjectPage", "CreateProjectPage", "URL_CREATE_PROJECT"),
    PageTest("7376", "AllProjectsPage", "AllProjectsPage", "URL_ALL_PROJECTS"),
    PageTest("7377", "SingleProjectPage", "SingleProjectPage", f"URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID}"),

    # Scenarios
    PageTest("7378", "AddScenarioPage", "AddScenarioPage", f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/add-scenario"'),
    PageTest("7379", "AllScenariosPage", "AllScenariosPage", f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/view-all-scenarios"'),
    PageTest("7380", "ScenarioHistoryPage", "ScenarioHistoryPage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/scenario-history/" + {TEST_SCENARIO_ID}'),

    # Test cases
    PageTest("7381", "AddTestCasePage", "AddTestCasePage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/scenario/" + {TEST_SCENARIO_ID} + "/add-test-case"'),
    PageTest("7382", "AllTestCasesPage", "AllTestCasesPage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/all-test-cases"'),
    PageTest("7383", "GetTestCasePage", "GetTestCasePage", f"URL_GET_TEST_CASE_BASE + {TEST_ID}"),
    PageTest("7384", "TestCaseDetailPage", "TestCaseDetailPage", f"URL_TEST_CASE_DETAIL_BASE + {TEST_ID}"),
    PageTest("7385", "TestCaseDashboardPage", "TestCaseDashboardPage", "URL_TEST_CASE_DASHBOARD"),
    PageTest("7386", "TraceabilityMatrixPage", "TraceabilityMatrixPage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/traceability-matrix"'),

    # Tasks
    PageTest("7387", "AssignTaskPage", "AssignTaskPage", f'URL_ASSIGN_TASK_BASE + {TEST_PROJECT_ID} + "/assign-task"'),
    PageTest("7388", "ViewAllTasksPage", "ViewAllTasksPage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/view-all-tasks"'),
    PageTest("7389", "ViewAssignedTasksPage", "ViewAssignedTasksPage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/user-assigned-tasks/" + {TEST_USER_ID}'),
    PageTest("7390", "TaskHistoryPage", "TaskHistoryPage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/single-task/" + {TEST_TASK_ID}'),

    # Defects / bugs
    PageTest("7391", "AddDefectPage", "AddDefectPage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/add-defect"'),
    PageTest("7392", "AllDefectsPage", "AllDefectsPage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/all-defects"'),
    PageTest("7393", "DefectDetailsPage", "DefectDetailsPage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/defect/" + {TEST_DEFECT_ID}'),
    PageTest("7394", "BugHistoryPage", "BugHistoryPage", f"URL_BUG_HISTORY_BASE + {TEST_DEFECT_ID}"),
    PageTest("7395", "AssignDefectPage", "AssignDefectPage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/assign-defect/" + {TEST_DEFECT_ID}'),
    PageTest("7396", "DeveloperAssignedDefectsPage", "DeveloperAssignedDefectsPage",
             f'URL_SINGLE_PROJECT_BASE + {TEST_PROJECT_ID} + "/developer/" + {TEST_DEV_ID} + "/view-assigned-defects"'),

    # Assigned projects
    PageTest("7397", "AssignedProjectsPage", "AssignedProjectsPage", f"URL_USER_ASSIGNED_PROJECTS_BASE + {TEST_USER_ID}"),

    # PM/Lead dashboards
    PageTest("7398", "ProjectManagerDashboardPage", "ProjectManagerDashboardPage", "URL_PROJECT_MANAGER_DASHBOARD"),
    PageTest("7399", "DeveloperLeadDashboardPage", "DeveloperLeadDashboardPage", "URL_DEVELOPER_LEAD_DASHBOARD"),

    # Requirements
    PageTest("7400", "CreateRequirementPage", "CreateRequirementPage", f"URL_CREATE_REQUIREMENT_BASE + {TEST_PROJECT_ID}"),
    PageTest("7401", "AllRequirementsPage", "AllRequirementsPage", f"URL_ALL_REQUIREMENTS_BASE + {TEST_PROJECT_ID}"),
    PageTest("7402", "RequirementsByModulePage", "RequirementsByModulePage",
             f'URL_ALL_REQUIREMENTS_BASE + {TEST_PROJECT_ID} + "/module/" + {TEST_MODULE_NAME}'),
    PageTest("7403", "ModuleRequirementsPage", "ModuleRequirementsPage",
             f'URL_MODULE_REQUIREMENTS_BASE + {TEST_PROJECT_ID} + "/" + {TEST_MODULE_NAME}'),
    PageTest("7404", "SingleRequirementPage", "SingleRequirementPage", f"URL_SINGLE_REQUIREMENT_BASE + {TEST_ID}"),
    PageTest("7405", "UpdateRequirementPage", "UpdateRequirementPage", f"URL_UPDATE_REQUIREMENT_BASE + {TEST_ID}"),

    # Events
    PageTest("7406", "CreateEventPage", "CreateEventPage", "URL_CREATE_EVENT"),
    PageTest("7407", "AllEventsPage", "AllEventsPage", "URL_ALL_EVENTS"),
    PageTest("7408", "SingleEventPage", "SingleEventPage", f"URL_SINGLE_EVENT_BASE + {TEST_ID}"),
    PageTest("7409", "UpdateEventPage", "UpdateEventPage", f"URL_UPDATE_EVENT_BASE + {TEST_ID}"),
    PageTest("7410", "UserEventsPage", "UserEventsPage", "URL_USER_EVENTS"),
    PageTest("7411", "SingleUserEventPage", "SingleUserEventPage", f"URL_SINGLE_USER_EVENT_BASE + {TEST_ID}"),

    # Attendance
    PageTest("7412", "CreateAttendancePage", "CreateAttendancePage", "URL_CREATE_ATTENDANCE"),
    PageTest("7413", "GetAllAttendancePage", "GetAllAttendancePage", "URL_VIEW_ALL_ATTENDANCE"),
    PageTest("7414", "SingleAttendancePage", "SingleAttendancePage", f"URL_GET_SINGLE_ATTENDANCE_BASE + {TEST_ID}"),
    PageTest("7415", "EditAttendancePage", "EditAttendancePage", f"URL_EDIT_ATTENDANCE_BASE + {TEST_ID}"),

    # Notifications
    PageTest("7416", "CreateNotificationPage", "CreateNotificationPage", "URL_CREATE_NOTIFICATION"),
    PageTest("7417", "AllNotificationsPage", "AllNotificationsPage", "URL_ALL_NOTIFICATIONS"),
    PageTest("7418", "UserNotificationsPage", "UserNotificationsPage", "URL_USER_NOTIFICATIONS"),
    PageTest("7419", "UserNotificationDetailPage", "UserNotificationDetailPage",
             f"URL_USER_NOTIFICATION_DETAIL_BASE + {TEST_NOTIFICATION_ID}"),

    # Messages
    PageTest("7420", "AllMessagesPage", "AllMessagesPage", "URL_ALL_MESSAGES"),
    PageTest("7421", "ReplyMessagePage", "ReplyMessagePage", f"URL_REPLY_MESSAGE_BASE + {TEST_ID}"),
    PageTest("7422", "AllRepliesPage", "AllRepliesPage", "URL_ALL_REPLIES"),

    # Todo
    PageTest("7423", "CreateTodoListPage", "CreateTodoListPage", "URL_CREATE_TODO_LIST"),
    PageTest("7424", "AllTodoTaskListPage", "AllTodoTaskListPage", "URL_VIEW_ALL_TODO_LIST"),
]

def main():
    created = 0
    for t in tests:
        out_dir = dir_from_pom(t.pom_class)
        ensure_dir(out_dir)

        java_path = os.path.join(out_dir, f"{class_name(t.scenario_no, t.pom_class)}.java")
        write_file(java_path, make_java(t))
        created += 1

    print(f"✅ Generated {created} TestNG classes under: {TEST_JAVA_ROOT}")
    print("✅ Example homepage path:")
    print("   src/test/java/scripts/homepage_scenarios/functional_scenarios")

if __name__ == "__main__":
    main()