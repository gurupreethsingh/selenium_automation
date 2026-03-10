package generic;

public interface AutomationConstants {

	// ============================================================
	// ✅ CORE
	// ============================================================
	String BASE_URL = "http://localhost:5173";
	String ROOT_DIRECTORY = System.getProperty("user.dir");
	String EXCEL_SHEET_PATH = ROOT_DIRECTORY + "\\project_documents.xlsx";
	String FAILED_SCREENSHOT_FOLDER = ROOT_DIRECTORY + "\\failed_screenshots";

	// ============================================================
	// ✅ PUBLIC / COMMON ROUTES (STATIC)
	// ============================================================
	String URL_HOME = BASE_URL + "/";
	String URL_HOME_ALT_1 = BASE_URL + "/home";
	String URL_HOME_ALT_2 = BASE_URL + "/homepage";

	String URL_PROJECTS = BASE_URL + "/projects";
	String URL_EXPLORE_SOLUTIONS = BASE_URL + "/explore-solutions";
	String URL_AI_SYSTEMS = BASE_URL + "/ai-systems";
	String URL_BLOCKCHAIN = BASE_URL + "/blockchain";
	String URL_WEB_APPS = BASE_URL + "/web-apps";
	String URL_QA_AUTOMATION = BASE_URL + "/qa-automation";

	String URL_LOGIN = BASE_URL + "/login";
	String URL_REGISTER = BASE_URL + "/register";

	String URL_CONTACT = BASE_URL + "/contact";

	String URL_PRIVACY_POLICY = BASE_URL + "/privacy-policy";
	String URL_ABOUT_US = BASE_URL + "/about-us";
	String URL_CAREERS = BASE_URL + "/careers";

	String URL_ALL_BLOGS = BASE_URL + "/all-blogs";
	String URL_ADD_BLOG = BASE_URL + "/add-blog";

	String URL_PAGE_NOT_FOUND = BASE_URL + "/page-not-found";

	// ============================================================
	// ✅ ADMIN / SUPERADMIN / DASHBOARDS (STATIC)
	// ============================================================
	String URL_DASHBOARD = BASE_URL + "/dashboard";

	String URL_ALL_USERS = BASE_URL + "/all-users";
	String URL_SINGLE_USER_BASE = BASE_URL + "/single-user/"; // + {id}

	String URL_ALL_SUBSCRIPTIONS = BASE_URL + "/all-subscriptions";

	String URL_SUPER_ADMIN_DASHBOARD = BASE_URL + "/super-admin-dashboard";
	String URL_ADMIN_DASHBOARD = BASE_URL + "/admin-dashboard";
	String URL_QA_DASHBOARD = BASE_URL + "/qa-dashboard";
	String URL_TEST_ENGINEER_DASHBOARD = BASE_URL + "/test-engineer-dashboard";
	String URL_DEVELOPER_DASHBOARD = BASE_URL + "/developer-dashboard";

	// ============================================================
	// ✅ CAREERS (DYNAMIC)
	// ============================================================
	String URL_ALL_CAREERS_APPLICATIONS = BASE_URL + "/all-careers-applications";
	String URL_SINGLE_CAREERS_APPLICATION_TEMPLATE = BASE_URL + "/single-careers-applications/:id";
	String URL_SINGLE_CAREERS_APPLICATION_BASE = BASE_URL + "/single-careers-applications/"; // + {id}

	// ============================================================
	// ✅ REPORTS (DYNAMIC)
	// ============================================================
	String URL_ALL_REPORTS = BASE_URL + "/all-reports";
	String URL_SINGLE_REPORT_TEMPLATE = BASE_URL + "/single-report/:id";
	String URL_SINGLE_REPORT_BASE = BASE_URL + "/single-report/"; // + {id}

	String URL_GENERATE_REPORT_TEMPLATE = BASE_URL + "/single-project/:projectId/generate-report";
	String URL_GENERATE_REPORT_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/generate-report"

	// ============================================================
	// ✅ BLOGS (DYNAMIC)
	// ============================================================
	String URL_SINGLE_BLOG_TEMPLATE = BASE_URL + "/single-blog/:slug/:id";
	String URL_SINGLE_BLOG_BASE = BASE_URL + "/single-blog/"; // + {slug} + "/" + {id}

	String URL_UPDATE_BLOG_TEMPLATE = BASE_URL + "/update-blog/:slug/:id";
	String URL_UPDATE_BLOG_BASE = BASE_URL + "/update-blog/"; // + {slug} + "/" + {id}

	// ============================================================
	// ✅ PROFILE (DYNAMIC)
	// ============================================================
	String URL_PROFILE_TEMPLATE = BASE_URL + "/profile/:id";
	String URL_PROFILE_BASE = BASE_URL + "/profile/"; // + {id}

	String URL_UPDATE_PROFILE_TEMPLATE = BASE_URL + "/update-profile/:id";
	String URL_UPDATE_PROFILE_BASE = BASE_URL + "/update-profile/"; // + {id}

	// ============================================================
	// ✅ PROJECTS (DYNAMIC + STATIC)
	// ============================================================
	String URL_CREATE_PROJECT = BASE_URL + "/create-project";
	String URL_ALL_PROJECTS = BASE_URL + "/all-projects";

	String URL_SINGLE_PROJECT_TEMPLATE = BASE_URL + "/single-project/:projectId";
	String URL_SINGLE_PROJECT_BASE = BASE_URL + "/single-project/"; // + {projectId}

	String URL_ADD_SCENARIO_TEMPLATE = BASE_URL + "/single-project/:projectId/add-scenario";
	String URL_ADD_SCENARIO_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/add-scenario"

	String URL_VIEW_ALL_SCENARIOS_TEMPLATE = BASE_URL + "/single-project/:projectId/view-all-scenarios";
	String URL_VIEW_ALL_SCENARIOS_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/view-all-scenarios"

	String URL_SCENARIO_HISTORY_TEMPLATE = BASE_URL + "/single-project/:projectId/scenario-history/:scenarioId";
	String URL_SCENARIO_HISTORY_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/scenario-history/" +
																		// {scenarioId}

	// ============================================================
	// ✅ TEST CASES (DYNAMIC + STATIC)
	// ============================================================
	String URL_ADD_TEST_CASE_TEMPLATE = BASE_URL + "/single-project/:projectId/scenario/:scenarioId/add-test-case";
	String URL_ADD_TEST_CASE_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/scenario/" + {scenarioId} +
																	// "/add-test-case"

	String URL_ALL_TEST_CASES_TEMPLATE = BASE_URL + "/single-project/:projectId/all-test-cases";
	String URL_ALL_TEST_CASES_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/all-test-cases"

	String URL_GET_TEST_CASE_TEMPLATE = BASE_URL + "/get-test-case/:id";
	String URL_GET_TEST_CASE_BASE = BASE_URL + "/get-test-case/"; // + {id}

	String URL_TEST_CASE_DETAIL_TEMPLATE = BASE_URL + "/test-case-detail/:id";
	String URL_TEST_CASE_DETAIL_BASE = BASE_URL + "/test-case-detail/"; // + {id}

	String URL_TEST_CASE_DASHBOARD = BASE_URL + "/test-case-dashboard";

	String URL_TRACEABILITY_MATRIX_TEMPLATE = BASE_URL + "/single-project/:projectId/traceability-matrix";
	String URL_TRACEABILITY_MATRIX_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/traceability-matrix"

	// ============================================================
	// ✅ TASKS (DYNAMIC)
	// ============================================================
	String URL_ASSIGN_TASK_TEMPLATE = BASE_URL + "/projects/:projectId/assign-task";
	String URL_ASSIGN_TASK_BASE = BASE_URL + "/projects/"; // + {projectId} + "/assign-task"

	String URL_VIEW_ALL_TASKS_TEMPLATE = BASE_URL + "/single-project/:projectId/view-all-tasks";
	String URL_VIEW_ALL_TASKS_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/view-all-tasks"

	String URL_USER_ASSIGNED_PROJECTS_BASE = BASE_URL + "/user-assigned-projects/"; // + {userId}

	String URL_USER_ASSIGNED_TASKS_TEMPLATE = BASE_URL + "/single-project/:projectId/user-assigned-tasks/:userId";
	String URL_USER_ASSIGNED_TASKS_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/user-assigned-tasks/" +
																			// {userId}

	String URL_SINGLE_TASK_TEMPLATE = BASE_URL + "/single-project/:projectId/single-task/:taskId";
	String URL_SINGLE_TASK_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/single-task/" + {taskId}

	// ============================================================
	// ✅ DEFECTS / BUGS (DYNAMIC)
	// ============================================================
	String URL_ADD_DEFECT_TEMPLATE = BASE_URL + "/single-project/:projectId/add-defect";
	String URL_ADD_DEFECT_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/add-defect"

	String URL_ALL_DEFECTS_TEMPLATE = BASE_URL + "/single-project/:projectId/all-defects";
	String URL_ALL_DEFECTS_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/all-defects"

	String URL_SINGLE_DEFECT_TEMPLATE = BASE_URL + "/single-project/:projectId/defect/:defectId";
	String URL_SINGLE_DEFECT_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/defect/" + {defectId}

	String URL_BUG_HISTORY_BASE = BASE_URL + "/bug-history/"; // + {defectId}

	String URL_ASSIGN_DEFECT_TEMPLATE = BASE_URL + "/single-project/:projectId/assign-defect/:defectId";
	String URL_ASSIGN_DEFECT_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/assign-defect/" + {defectId}

	String URL_DEVELOPER_ASSIGNED_DEFECTS_TEMPLATE = BASE_URL
			+ "/single-project/:projectId/developer/:developerId/view-assigned-defects";
	String URL_DEVELOPER_ASSIGNED_DEFECTS_BASE = BASE_URL + "/single-project/"; // + {projectId} + "/developer/" +
																				// {developerId} +
																				// "/view-assigned-defects"

	// ============================================================
	// ✅ PM / DEV LEAD DASHBOARDS (STATIC)
	// ============================================================
	String URL_PROJECT_MANAGER_DASHBOARD = BASE_URL + "/project-manager-dashboard";
	String URL_DEVELOPER_LEAD_DASHBOARD = BASE_URL + "/developer-lead-dashboard";

	// ============================================================
	// ✅ REQUIREMENTS (DYNAMIC)
	// ============================================================
	String URL_CREATE_REQUIREMENT_TEMPLATE = BASE_URL + "/create-requirement/:projectId";
	String URL_CREATE_REQUIREMENT_BASE = BASE_URL + "/create-requirement/"; // + {projectId}

	String URL_ALL_REQUIREMENTS_TEMPLATE = BASE_URL + "/all-requirements/:projectId";
	String URL_ALL_REQUIREMENTS_BASE = BASE_URL + "/all-requirements/"; // + {projectId}

	String URL_ALL_REQUIREMENTS_BY_MODULE_TEMPLATE = BASE_URL + "/all-requirements/:projectId/module/:moduleName";
	String URL_ALL_REQUIREMENTS_BY_MODULE_BASE = BASE_URL + "/all-requirements/"; // + {projectId} + "/module/" +
																					// {moduleName}

	String URL_MODULE_REQUIREMENTS_TEMPLATE = BASE_URL + "/module-requirements/:projectId/:moduleName";
	String URL_MODULE_REQUIREMENTS_BASE = BASE_URL + "/module-requirements/"; // + {projectId} + "/" + {moduleName}

	String URL_SINGLE_REQUIREMENT_BASE = BASE_URL + "/single-requirement/"; // + {id}
	String URL_UPDATE_REQUIREMENT_BASE = BASE_URL + "/update-requirement/"; // + {id}

	// ============================================================
	// ✅ EVENTS (STATIC + DYNAMIC)
	// ============================================================
	String URL_CREATE_EVENT = BASE_URL + "/create-event";
	String URL_ALL_EVENTS = BASE_URL + "/all-events";
	String URL_USER_EVENTS = BASE_URL + "/user-events";

	String URL_SINGLE_EVENT_BASE = BASE_URL + "/single-event/"; // + {id}
	String URL_UPDATE_EVENT_BASE = BASE_URL + "/update-event/"; // + {id}
	String URL_SINGLE_USER_EVENT_BASE = BASE_URL + "/single-user-event/"; // + {id}

	// ============================================================
	// ✅ ATTENDANCE (STATIC + DYNAMIC)
	// ============================================================
	String URL_CREATE_ATTENDANCE = BASE_URL + "/create-attendance";
	String URL_VIEW_ALL_ATTENDANCE = BASE_URL + "/view-all-attendance";
	String URL_GET_SINGLE_ATTENDANCE_BASE = BASE_URL + "/get-single-attendance/"; // + {id}
	String URL_EDIT_ATTENDANCE_BASE = BASE_URL + "/edit-attendance/"; // + {id}

	// ============================================================
	// ✅ NOTIFICATIONS (STATIC + DYNAMIC)
	// ============================================================
	String URL_CREATE_NOTIFICATION = BASE_URL + "/create-notification";
	String URL_ALL_NOTIFICATIONS = BASE_URL + "/all-notifications";
	String URL_USER_NOTIFICATIONS = BASE_URL + "/user-notifications";
	String URL_USER_NOTIFICATION_DETAIL_BASE = BASE_URL + "/user-notifications/"; // + {notificationId}

	// ============================================================
	// ✅ CONTACT / MESSAGES (STATIC + DYNAMIC)
	// ============================================================
	String URL_ALL_MESSAGES = BASE_URL + "/all-messages";
	String URL_ALL_REPLIES = BASE_URL + "/all-replies";
	String URL_REPLY_MESSAGE_BASE = BASE_URL + "/reply-message/"; // + {id}

	// ============================================================
	// ✅ TODO TASK MODULE (STATIC)
	// ============================================================
	String URL_CREATE_TODO_LIST = BASE_URL + "/create-todo-list";
	String URL_VIEW_ALL_TODO_LIST = BASE_URL + "/view-all-todo-list";

	// ============================================================
	// ✅ SELENIUM PRACTICE PAGES (STATIC)
	// ============================================================
	String URL_TEXT_OPERATIONS = BASE_URL + "/text-operations";
	String URL_ALERT_OPERATIONS = BASE_URL + "/alert-operations";
	String URL_FRAME_OPERATIONS = BASE_URL + "/frame-operations";
	String URL_SCROLL_OPERATIONS = BASE_URL + "/scroll-operations";
	String URL_DROPDOWN_OPERATIONS = BASE_URL + "/dropdown-operations";
	String URL_INPUT_FIELD_OPERATIONS = BASE_URL + "/input-field-operations";
	String URL_CLICK_OPERATIONS = BASE_URL + "/click-operations";

}
