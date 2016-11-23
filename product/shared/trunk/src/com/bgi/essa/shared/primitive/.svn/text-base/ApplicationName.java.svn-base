package com.bgi.essa.shared.primitive;

import java.io.Serializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Define legal application name.  These map to VPO messages.
 * 
 * @author coleguy
 */
public class ApplicationName implements Serializable {

	/**
	 * Return a string representing the state (value) of this instance.
	 * 
	 * @return a string representing the state (value) of this instance.
	 */
	public String toString() {
		return(_value);
	}

	/**
	 * Return object state as a XML formatted string 
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return(_value);
	}
	
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @param tag xml tag
	 * @return object state as a XML formatted string
	 * @throws NullPointerException if tag is null
	 */
	public String toXml(String tag) {
		if (tag == null) {
			throw new NullPointerException("null XML tag");
		}
		
		return("<" + tag + ">" + toXml() + "</" + tag + ">");
	}

	/**
	 * Return hash code for this object.
	 * 
	 * @return hash code for this object
	 */
	public int hashCode() {
		return(11 * _value.hashCode());
	}

	/**
	 * Return true if objects match
	 * 
	 * @param arg test candidate
	 * @return true if periods match
	 * @throws ClassCastException if arg cannot be cast
	 */
	public boolean equals(final Object arg) {
		if (arg == null) {
			return(false);
		}

		final ApplicationName temp = (ApplicationName) arg;
		return(_value.equals(temp._value));
	}
	
	/**
	 * Private ctor
	 * 
	 * @param arg select option value
	 */
	private ApplicationName(final String arg) {
		_value = arg;
	}
	
	/**
	 * ApplicationName value.
	 */
	private final String _value;
	
	/**
	 * Return the type corresponding to arg, or null if not found.
	 * 
	 * @param arg type (key) to search for.
	 * @return the type corresponding to arg, or null if not found.
	 */
	public static ApplicationName getInstance(final String arg) {
		return(_instances.get(arg));
	}
	
	/**
	 * Return a sorted array of keys
	 * 
	 * @return sorted array of keys
	 */
	public static String[] getSortedKeys() {
		String[] keyz = _instances.keySet().toArray(new String[0]);
		Arrays.sort(keyz);
		return(keyz);
	}
	
	/**
	 * Return all instances
	 * 
	 * @return all instances
	 */
	public static Map<String, ApplicationName> getAll() {
		return(_instances);
	}
	
	/**
	 * Map of instances, employed to look up types.
	 */
	private static final Map<String, ApplicationName> _instances = new HashMap<String, ApplicationName>();

	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -1404766029752316732L;

	/**
	 * 
	 */
	public static final ApplicationName ACCOUNTS_BARCLAYSGLOBAL = new ApplicationName("accounts-barclaysglobal");
	public static final ApplicationName ADMINISTRATION = new ApplicationName("administration");
	public static final ApplicationName ADVANTAGE = new ApplicationName("advantage");
	public static final ApplicationName AIS = new ApplicationName("ais");
	public static final ApplicationName AIS_INCEPTION = new ApplicationName("ais_inception");
	public static final ApplicationName ALARMPOINT = new ApplicationName("alarmpoint");
	public static final ApplicationName AMSX = new ApplicationName("amsx");
	public static final ApplicationName AMSX_LOAD = new ApplicationName("amsx_load");
	public static final ApplicationName AP1 = new ApplicationName("ap1");
	public static final ApplicationName APEX = new ApplicationName("apex");
	public static final ApplicationName APP_DESK = new ApplicationName("appdesk");
	public static final ApplicationName APPMANAGER = new ApplicationName("appmanager");
	public static final ApplicationName APPMANAGER_APPLICATION = new ApplicationName("appmanager_application");
	public static final ApplicationName APPMANAGER_BACKUP = new ApplicationName("appmanager_backupexec");
	public static final ApplicationName APPMANAGER_CIM = new ApplicationName("appmanager_cim");
	public static final ApplicationName APPMANAGER_EXCHANGE = new ApplicationName("appmanager_exchange");
	public static final ApplicationName APPMANAGER_HELPDESK = new ApplicationName("appmanager_helpdesk");
	public static final ApplicationName APPMANAGER_IIS = new ApplicationName("appmanager_iis");
	public static final ApplicationName APPMANAGER_ISA = new ApplicationName("appmanager_isa");
	public static final ApplicationName APPMANAGER_NT = new ApplicationName("appmanager_nt");
	public static final ApplicationName APPMANAGER_NTADMIN = new ApplicationName("appmanager_ntadmin");
	public static final ApplicationName APPMANAGER_SQL = new ApplicationName("appmanager_sql");
	public static final ApplicationName APPMANAGER_WTS = new ApplicationName("appmanager_wts");
	public static final ApplicationName ARIA_JAP_CANOTICE = new ApplicationName("aria_jap_canotice");
	public static final ApplicationName ARIA_JAP_CLIENT = new ApplicationName("aria_jap_client");
	public static final ApplicationName ARIA_JAP_CLIENTORDER = new ApplicationName("aria_jap_clientorder");
	public static final ApplicationName ARIA_JAP_EXECUTION = new ApplicationName("aria_jap_execution");
	public static final ApplicationName ARIA_JAP_FXRATE = new ApplicationName("aria_jap_fxrate");
	public static final ApplicationName ARIA_JAP_GENERIC = new ApplicationName("aria_jap_generic");
	public static final ApplicationName ARIA_JAP_LOANQUOTE = new ApplicationName("aria_jap_loanquote");
	public static final ApplicationName ARIA_JAP_ONLOAN= new ApplicationName("aria_jap_onloanreport");
	public static final ApplicationName ARIA_JAP_RRR = new ApplicationName("aria_jap_rrr");
	public static final ApplicationName ARIA_JAP_UNITPRICE = new ApplicationName("aria_jap_unitprice");
	public static final ApplicationName ART = new ApplicationName("art");
	public static final ApplicationName ASCOT = new ApplicationName("ascot");
	public static final ApplicationName ASG = new ApplicationName("asg");
	public static final ApplicationName ASI = new ApplicationName("asi");
	public static final ApplicationName ASI_NETWORK = new ApplicationName("asi-network");
	public static final ApplicationName ASM = new ApplicationName("asm");
	public static final ApplicationName AUST_FTINTERACTIVE = new ApplicationName("aust_ftinteractive");
	public static final ApplicationName AUTOPACKAGER = new ApplicationName("autopackager");
	public static final ApplicationName AUTOSYS = new ApplicationName("autosys");
	public static final ApplicationName BACKUP = new ApplicationName("backup");
	public static final ApplicationName BARCLAYSGLOBAL = new ApplicationName("barclaysglobal");
	public static final ApplicationName BEP = new ApplicationName("bep");
	public static final ApplicationName BG_ARIA = new ApplicationName("bg-aria");
	public static final ApplicationName BG_AUS = new ApplicationName("bg_aus");
	public static final ApplicationName BG_CAN = new ApplicationName("bg_can");
	public static final ApplicationName BGICASH = new ApplicationName("bgicash");
	public static final ApplicationName BGICASHFUNDS = new ApplicationName("bgicashfunds");
	public static final ApplicationName BGICONNECT_AUS = new ApplicationName("bgiconnect_aus");
	public static final ApplicationName BGIFUNDS = new ApplicationName("bgifunds");
	public static final ApplicationName BGIS_FI_PROD = new ApplicationName("bgis_fi_prod");
	public static final ApplicationName BGIS_FI_QA = new ApplicationName("bgis_fi_qa");
	public static final ApplicationName BGIS_UK = new ApplicationName("bgis_uk");
	public static final ApplicationName BGIS_UK_QA = new ApplicationName("bgis_uk_qa");
	public static final ApplicationName BGIS_US = new ApplicationName("bgis_us");
	public static final ApplicationName BIDBOOK = new ApplicationName("bidbook");
	public static final ApplicationName BIP = new ApplicationName("bip");
	public static final ApplicationName BLOOMBERG_RECON = new ApplicationName("bloomberg_recon");
	public static final ApplicationName BMS = new ApplicationName("bms");
	public static final ApplicationName BRSI = new ApplicationName("brsi");
	public static final ApplicationName CALYPSO = new ApplicationName("calypso");
	public static final ApplicationName CANDEVEMAIL = new ApplicationName("candevemail");
	public static final ApplicationName CAST = new ApplicationName("cast");
	public static final ApplicationName CENTAURI_UK = new ApplicationName("centauri_uk");
	public static final ApplicationName CERTIFICATE = new ApplicationName("certificate");
	public static final ApplicationName CFMAIL = new ApplicationName("cfmail");
	public static final ApplicationName CHARLES_RIVER = new ApplicationName("charles_river");
	public static final ApplicationName CHECKPOINT = new ApplicationName("checkpoint");
	public static final ApplicationName CIPIT = new ApplicationName("cipit");
	public static final ApplicationName CITRIX = new ApplicationName("citrix");
	public static final ApplicationName CLIENT_APPLICATIONS = new ApplicationName("client_applications");
	public static final ApplicationName COM = new ApplicationName("com");
	public static final ApplicationName COM_SEC = new ApplicationName("comm_sec");
	public static final ApplicationName COMPACT = new ApplicationName("compact");
	public static final ApplicationName CONCERT = new ApplicationName("concert");
	public static final ApplicationName CP = new ApplicationName("cp");
	public static final ApplicationName CP_MS_UK = new ApplicationName("cp_ms_uk");
	public static final ApplicationName CPDL = new ApplicationName("cpdl");
	public static final ApplicationName CPDL_JP = new ApplicationName("cpdl_jp");
	public static final ApplicationName CR_UK = new ApplicationName("cr_uk");
	public static final ApplicationName CRS = new ApplicationName("crs");
	public static final ApplicationName CRYSTAL_ENTERPRISE = new ApplicationName("crystal_enterprise");
	public static final ApplicationName CSM = new ApplicationName("csm");
	public static final ApplicationName DATABASE = new ApplicationName("database");
	public static final ApplicationName DATACENTER = new ApplicationName("datacenter");
	public static final ApplicationName DBSPI = new ApplicationName("dbspi");
	public static final ApplicationName DBSSI = new ApplicationName("dbssi");
	public static final ApplicationName DELTA = new ApplicationName("delta");
	public static final ApplicationName DELTA_UK = new ApplicationName("delta_uk");
	public static final ApplicationName DEV_RPT = new ApplicationName("dev_rpt");
	public static final ApplicationName DEVICEQUERY = new ApplicationName("devicequery");
	public static final ApplicationName DEVNET = new ApplicationName("devnet");
	public static final ApplicationName DEVTEST = new ApplicationName("devtest");
	public static final ApplicationName DOCUMENTUM = new ApplicationName("documentum");
	public static final ApplicationName DYNAMO = new ApplicationName("dynamo");
	public static final ApplicationName EAT = new ApplicationName("eat");
	public static final ApplicationName EMC_ALARMS = new ApplicationName("emc_alarms");
	public static final ApplicationName EMX = new ApplicationName("emx");
	public static final ApplicationName EQUILEND = new ApplicationName("equilend");
	public static final ApplicationName EQUILEND_B= new ApplicationName("equilend_b");
	public static final ApplicationName ESM = new ApplicationName("esm");
	public static final ApplicationName ETF = new ApplicationName("etf");
	public static final ApplicationName FI_SOVPLUS = new ApplicationName("fi-sovplus");
	public static final ApplicationName FI_BATCH = new ApplicationName("fi_batch");
	public static final ApplicationName FIDAP = new ApplicationName("fidap");
	public static final ApplicationName FIDS = new ApplicationName("fids");
	public static final ApplicationName FLEXTRADE = new ApplicationName("flextrade");
	public static final ApplicationName GAA_AASG = new ApplicationName("gaa_aasg");
	public static final ApplicationName GAA_ACM = new ApplicationName("gaa_acm");
	public static final ApplicationName GAA_ADG = new ApplicationName("gaa_adg");
	public static final ApplicationName GAA_AIG = new ApplicationName("gaa_aig");
	public static final ApplicationName GAA_AMG = new ApplicationName("gaa_amg");
	public static final ApplicationName GAA_APLUS = new ApplicationName("gaa_aplus");
	public static final ApplicationName GAA_ASGINTL = new ApplicationName("gaa_asgintl");
	public static final ApplicationName GAA_ASGUS = new ApplicationName("gaa_asgus");
	public static final ApplicationName GAA_ATG = new ApplicationName("gaa_atg");
	public static final ApplicationName GAA_AURG = new ApplicationName("gaa_aurg");
	public static final ApplicationName GAA_CNRG = new ApplicationName("gaa_cnrg");
	public static final ApplicationName GAA_ETG = new ApplicationName("gaa_etg");
	public static final ApplicationName GAA_FASER = new ApplicationName("gaa_faser");
	public static final ApplicationName GAA_GAEPM = new ApplicationName("gaa_gaepm");
	public static final ApplicationName GAA_GAEPM_UK_AA = new ApplicationName("gaa_gaepm_uk_aa");
	public static final ApplicationName GAA_GAEPM_UK_ALPHA = new ApplicationName("gaa_gaepm_uk_alphagen");
	public static final ApplicationName GAA_GROWTHEQ = new ApplicationName("gaa_growtheq");
	public static final ApplicationName GAA_GTAA = new ApplicationName("gaa_gtaa");
	public static final ApplicationName GAA_INTELLIS = new ApplicationName("gaa_intellis");
	public static final ApplicationName GAA_NEUALPHA= new ApplicationName("gaa_neualpha");
	public static final ApplicationName GAA_OTG = new ApplicationName("gaa_otg");
	public static final ApplicationName GAA_TPG = new ApplicationName("gaa_tpg");
	public static final ApplicationName GAA_TRG = new ApplicationName("gaa_trg");
	public static final ApplicationName GAA_UKPM = new ApplicationName("gaa_ukpm");
	public static final ApplicationName GAA_UNIX = new ApplicationName("gaa_unix");
	public static final ApplicationName GAA_UNIX_AUTOGEN = new ApplicationName("gaa_unix_autogen");
	public static final ApplicationName GAA_UNIX_WIP = new ApplicationName("gaa_unix_work_in_progress");
	public static final ApplicationName GAA_USAFI = new ApplicationName("gaa_usafi");
	public static final ApplicationName GAA_USSS = new ApplicationName("gaa_usss");
	public static final ApplicationName GATE = new ApplicationName("gate");
	public static final ApplicationName GCMFORM = new ApplicationName("gcmform");
	public static final ApplicationName GCOM = new ApplicationName("gcom");
	public static final ApplicationName GDS = new ApplicationName("gds");
	public static final ApplicationName GEM = new ApplicationName("gem");
	public static final ApplicationName GFIT = new ApplicationName("gfit");
	public static final ApplicationName GIFT = new ApplicationName("gift");
	public static final ApplicationName GIO = new ApplicationName("gio");
	public static final ApplicationName GIO_UNIX = new ApplicationName("gio-unix");
	public static final ApplicationName GITAP = new ApplicationName("gitap");
	public static final ApplicationName GLADIS = new ApplicationName("gladis");
	public static final ApplicationName GLM = new ApplicationName("glm");
	public static final ApplicationName GLM2 = new ApplicationName("glm2");
	public static final ApplicationName GLOBAL_ISHARES = new ApplicationName("global_ishares");
	public static final ApplicationName GLS_GATE = new ApplicationName("gls_gate");
	public static final ApplicationName GMD = new ApplicationName("gmd");
	public static final ApplicationName GMMT_APP_SERVER = new ApplicationName("gmmt_app_server");
	public static final ApplicationName GMMT_SOA = new ApplicationName("gmmt_soa");
	public static final ApplicationName GMSG = new ApplicationName("gmsg");
	public static final ApplicationName GOS = new ApplicationName("gos");
	public static final ApplicationName GOT_EUROPE = new ApplicationName("got_europe");
	public static final ApplicationName GOT_FTS = new ApplicationName("got_fts");
	public static final ApplicationName GOT_FTS_EMAIL = new ApplicationName("got_fts_email");
	public static final ApplicationName GOTUK = new ApplicationName("gotuk");
	public static final ApplicationName GPS = new ApplicationName("gps");
	public static final ApplicationName GSS_CFMAIL = new ApplicationName("gss_cfmail");
	public static final ApplicationName GSURVEYOR = new ApplicationName("gsurveyor");
	public static final ApplicationName HA = new ApplicationName("ha");
	public static final ApplicationName HARDCATWEB = new ApplicationName("hardcatweb");
	public static final ApplicationName HARDWARE = new ApplicationName("hardware");
	public static final ApplicationName HDI = new ApplicationName("hdi");
	public static final ApplicationName HELPDESK_UK = new ApplicationName("helpdesk_uk");
	public static final ApplicationName HELPME = new ApplicationName("helpme");
	public static final ApplicationName HFDP_DI = new ApplicationName("hfdp-di");
	public static final ApplicationName IA_US1 = new ApplicationName("ia-us");
	public static final ApplicationName IA_US2 = new ApplicationName("ia_us");
	public static final ApplicationName IBT_GATEWAY = new ApplicationName("ibt_gateway");
	public static final ApplicationName ICORE = new ApplicationName("icore");
	public static final ApplicationName IDL = new ApplicationName("idl");
	public static final ApplicationName IMM = new ApplicationName("imm");
	public static final ApplicationName IMS = new ApplicationName("ims");
	public static final ApplicationName INDICES = new ApplicationName("indices");
	public static final ApplicationName INFRADEV = new ApplicationName("infradev");
	public static final ApplicationName INTERNET_INFRASTRUCTURE = new ApplicationName("internet_infrastructure");
	public static final ApplicationName INTLPM = new ApplicationName("intlpm");
	public static final ApplicationName INTRASPECT = new ApplicationName("intraspect");
	public static final ApplicationName IPC = new ApplicationName("ipc");
	public static final ApplicationName IPLANET = new ApplicationName("iplanet");
	public static final ApplicationName ISHARES = new ApplicationName("ishares");
	public static final ApplicationName ISHARES_CA = new ApplicationName("ishares_ca");
	public static final ApplicationName ISHARES_FI_BUS = new ApplicationName("ishares_fi_bus");
	public static final ApplicationName ISHARES_FI_DEV = new ApplicationName("ishares_fi_dev");
	public static final ApplicationName ISHARES_NET = new ApplicationName("ishares_net");
	public static final ApplicationName ISSUE_PRICE = new ApplicationName("issue_price");
	public static final ApplicationName IUNITS = new ApplicationName("iunits");
	public static final ApplicationName IWEB = new ApplicationName("iweb");
	public static final ApplicationName JAVAEE_SUPPORT = new ApplicationName("javaee_support");
	public static final ApplicationName JOB = new ApplicationName("job");
	public static final ApplicationName JRUN = new ApplicationName("jrun");
	public static final ApplicationName K2DESK = new ApplicationName("k2desk");
	public static final ApplicationName KM_IT_PS = new ApplicationName("km_it_ps");
	public static final ApplicationName KMDP_DMSAPP = new ApplicationName("kmdp_dmsapp");
	public static final ApplicationName KMIT = new ApplicationName("kmit");
	public static final ApplicationName KMITPS = new ApplicationName("kmitps");
	public static final ApplicationName LOCKOUTS = new ApplicationName("lockouts");
	public static final ApplicationName MAC = new ApplicationName("mac");
	public static final ApplicationName MARKET_DATA_EUROPE = new ApplicationName("market_data_europe");
	public static final ApplicationName MARSHALL = new ApplicationName("marshall");
	public static final ApplicationName MISC = new ApplicationName("misc");
	public static final ApplicationName MQADMIN = new ApplicationName("mqadmin");
	public static final ApplicationName MQADMIN_SYD = new ApplicationName("mqadmin_syd");
	public static final ApplicationName MQADMIN_TKY = new ApplicationName("mqadmin_tky");
	public static final ApplicationName MQP_MQSERIES = new ApplicationName("mqp_mqseries");
	public static final ApplicationName MSS_ADMIN = new ApplicationName("mss_admin");
	public static final ApplicationName MSS_CONF = new ApplicationName("mss_conf");
	public static final ApplicationName MSS_FAULT = new ApplicationName("mss_fault");
	public static final ApplicationName MSS_PERF = new ApplicationName("mss_perf");
	public static final ApplicationName MSSQL_AMR = new ApplicationName("mssql-amr");
	public static final ApplicationName MSSQL_TEST = new ApplicationName("mssql-test");
	public static final ApplicationName MULTI_CURR = new ApplicationName("multi_curr");
	public static final ApplicationName NAS = new ApplicationName("nas");
	public static final ApplicationName NAS_EMAIL = new ApplicationName("nas_email");
	public static final ApplicationName NETAPPS = new ApplicationName("netapps");
	public static final ApplicationName NETBACKUP = new ApplicationName("netbackup");
	public static final ApplicationName NETBACKUP_EMAIL = new ApplicationName("netbackup_email");
	public static final ApplicationName NETWORK = new ApplicationName("network");
	public static final ApplicationName NETWORK_TEST = new ApplicationName("network_test");
	public static final ApplicationName NODE_STATUS = new ApplicationName("nodestatus");
	public static final ApplicationName NOTIFICATION = new ApplicationName("notification");
	public static final ApplicationName OFA = new ApplicationName("ofa");
	public static final ApplicationName OPC = new ApplicationName("opc");
	public static final ApplicationName OPENDEPLOY = new ApplicationName("opendeploy");
	public static final ApplicationName ORACLE = new ApplicationName("oracle");
	public static final ApplicationName ORBIS = new ApplicationName("orbis");
	public static final ApplicationName ORBIS_DISK_MONITORING1 = new ApplicationName("orbis-disk-monitoring");
	public static final ApplicationName ORBIS_DISK_MONITORING2 = new ApplicationName("orbis_disk_monitoring");
	public static final ApplicationName ORBIS_AUS = new ApplicationName("orbis_aus");
	public static final ApplicationName ORBIS_AUS_ESCALATE = new ApplicationName("orbis_aus_escalate");
	public static final ApplicationName ORBIS_AUS_RISK = new ApplicationName("orbis_aus_risk");
	public static final ApplicationName ORBIS_AUS_TRD = new ApplicationName("orbis_aus_trd");
	public static final ApplicationName ORBIS_CAN = new ApplicationName("orbis_can");
	public static final ApplicationName ORBIS_CAN_ESCALATE = new ApplicationName("orbis_can_escalate");
	public static final ApplicationName ORBIS_CAN_RISK = new ApplicationName("orbis_can_risk");
	public static final ApplicationName ORBIS_CAN_TRD = new ApplicationName("orbis_can_trd");
	public static final ApplicationName ORBIS_CROSSING = new ApplicationName("orbis_crossing");
	public static final ApplicationName ORBIS_CST = new ApplicationName("orbis_cst");
	public static final ApplicationName ORBIS_EQUITY = new ApplicationName("orbis_equity");
	public static final ApplicationName ORBIS_ESCALATE = new ApplicationName("orbis_escalate");
	public static final ApplicationName ORBIS_EUROPE = new ApplicationName("orbis_europe");
	public static final ApplicationName ORBIS_EUROPE_ESCALATE = new ApplicationName("orbis_europe_escalate");
	public static final ApplicationName ORBIS_QA = new ApplicationName("orbis_qa");
	public static final ApplicationName ORBIS_QA_UK = new ApplicationName("orbis_qa_uk");
	public static final ApplicationName ORBIS_RM = new ApplicationName("orbis_rm");
	public static final ApplicationName ORBIS_SUPPORT = new ApplicationName("orbis_support");
	public static final ApplicationName ORBIS_TRD = new ApplicationName("orbis_trd");
	public static final ApplicationName ORBIS_TRD_JAPAN = new ApplicationName("orbis_trd_japan");
	public static final ApplicationName ORBIS_TRD_JAPAN_ESCALATE = new ApplicationName("orbis_trd_japan_escalate");
	public static final ApplicationName ORBIS_UK = new ApplicationName("orbis_uk");
	public static final ApplicationName ORBIS_UK_CURRENCY = new ApplicationName("orbis_uk_currency");
	public static final ApplicationName ORBIS_UK_EQUITY = new ApplicationName("orbis_uk_equity");
	public static final ApplicationName ORBIS_US_AUTO = new ApplicationName("orbis_us_auto");
	public static final ApplicationName ORBIS_US_BREACH = new ApplicationName("orbis_us_breach");
	public static final ApplicationName ORBIS_US_CURRENCY = new ApplicationName("orbis_us_currency");
	public static final ApplicationName ORBIS_US_EQUITY = new ApplicationName("orbis_us_equity");
	public static final ApplicationName ORBIS_US_INDEX = new ApplicationName("orbis_us_index");
	public static final ApplicationName ORBIS_USIDXPM = new ApplicationName("orbis_usidxpm");
	public static final ApplicationName ORDERSONLINE = new ApplicationName("ordersonline");
	public static final ApplicationName OS = new ApplicationName("os");
	public static final ApplicationName OSSPI_CLUSTERS = new ApplicationName("osspi-clusters");
	public static final ApplicationName OSSPI_FS = new ApplicationName("osspi-fs");
	public static final ApplicationName OSSPI_INTERNAL = new ApplicationName("osspi-internal");
	public static final ApplicationName OSSPI_KERNEL = new ApplicationName("osspi-kernel");
	public static final ApplicationName OSSPI_SERVICES = new ApplicationName("osspi-services");
	public static final ApplicationName OVIS = new ApplicationName("ovis");
	public static final ApplicationName OZONE = new ApplicationName("ozone");
	public static final ApplicationName P3 = new ApplicationName("p3");
	public static final ApplicationName PACKAGING = new ApplicationName("packaging");
	public static final ApplicationName PARSW = new ApplicationName("parsw");
	public static final ApplicationName PB_RPT = new ApplicationName("pb_rpt");
	public static final ApplicationName PERFORMANCE = new ApplicationName("performance");
	public static final ApplicationName PIMS = new ApplicationName("pims");
	public static final ApplicationName PREP = new ApplicationName("prep");
	public static final ApplicationName PRISM = new ApplicationName("prism");
	public static final ApplicationName PURCHASING = new ApplicationName("purchasing");
	public static final ApplicationName PURCHASING_WEB = new ApplicationName("purchasing_web");
	public static final ApplicationName QPASA = new ApplicationName("qpasa");
	public static final ApplicationName RK = new ApplicationName("rk");
	public static final ApplicationName RKP = new ApplicationName("rkp");
	public static final ApplicationName SAN = new ApplicationName("san");
	public static final ApplicationName SAN_EMAIL = new ApplicationName("san_email");
	public static final ApplicationName SAPPHIRE = new ApplicationName("sapphire");
	public static final ApplicationName SATISHTEST = new ApplicationName("satishtest");
	public static final ApplicationName SEC_LENDING_SUPPORT = new ApplicationName("sec_lending_support");
	public static final ApplicationName SECSVCS = new ApplicationName("secsvcs");
	public static final ApplicationName SECURITY = new ApplicationName("security");
	public static final ApplicationName SENTINEL = new ApplicationName("sentinel");
	public static final ApplicationName SENTRY = new ApplicationName("sentry");
	public static final ApplicationName SERVICECENTER = new ApplicationName("servicecenter");
	public static final ApplicationName SHAREIT = new ApplicationName("shareit");
	public static final ApplicationName SHAREIT_TEST = new ApplicationName("shareit-test");
	public static final ApplicationName SNMP = new ApplicationName("snmp");
	public static final ApplicationName SOURCEFORGE = new ApplicationName("sourceforge");
	public static final ApplicationName SPI_SVCDISC = new ApplicationName("spi_svcdisc");
	public static final ApplicationName SPT_TKY_MN = new ApplicationName("spt-tky-mn");
	public static final ApplicationName STATEMENT = new ApplicationName("statement");
	public static final ApplicationName STORAGE = new ApplicationName("storage");
	public static final ApplicationName STORAGE_APAC = new ApplicationName("storage_apac");
	public static final ApplicationName STORAGE_LDN = new ApplicationName("storage_ldn");
	public static final ApplicationName STORAGE_RDC = new ApplicationName("storage_rdc");
	public static final ApplicationName STORAGE_SFO = new ApplicationName("storage_sfo");
	public static final ApplicationName SUMS = new ApplicationName("sums");
	public static final ApplicationName SWIFT = new ApplicationName("swift");
	public static final ApplicationName SWORDFISHWEBSERVICES = new ApplicationName("swordfishwebservices");
	public static final ApplicationName SYBASE = new ApplicationName("sybase");
	public static final ApplicationName SYBASE_TEST = new ApplicationName("sybase-test");
	public static final ApplicationName SYDDEV = new ApplicationName("syddev");
	public static final ApplicationName TAR = new ApplicationName("tar");
	public static final ApplicationName TEAMSITE = new ApplicationName("teamsite");
	public static final ApplicationName TECHTEAM = new ApplicationName("techteam");
	public static final ApplicationName TELECOM = new ApplicationName("telecom");
	public static final ApplicationName TELEDIRECT = new ApplicationName("teledirect");
	public static final ApplicationName TEST = new ApplicationName("test");
	public static final ApplicationName TEST_CS = new ApplicationName("test_cs");
	public static final ApplicationName TESTCENTER = new ApplicationName("testcenter");
	public static final ApplicationName TKY_CDB = new ApplicationName("tky_cdb");
	public static final ApplicationName TKY_IT_BO = new ApplicationName("tky_it_bo");
	public static final ApplicationName TKY_IT_GOT_JP = new ApplicationName("tky_it_got_jp");
	public static final ApplicationName TKY_PAS = new ApplicationName("tky_pas");
	public static final ApplicationName TKY_TPT = new ApplicationName("tky_tpt");
	public static final ApplicationName TKYDEV = new ApplicationName("tkydev");
	public static final ApplicationName TORAPPS = new ApplicationName("torapps");
	public static final ApplicationName TORINFRA = new ApplicationName("torinfra");
	public static final ApplicationName TRADEFLOOR = new ApplicationName("tradefloor");
	public static final ApplicationName TRANSFER = new ApplicationName("transfer");
	public static final ApplicationName TRANSVC = new ApplicationName("transvc");
	public static final ApplicationName TRIPLEA = new ApplicationName("triplea");
	public static final ApplicationName TSWEB = new ApplicationName("tsweb");
	public static final ApplicationName UK_IT_DEV = new ApplicationName("uk-it-dev");
	public static final ApplicationName UK_IT_DEV_ALP = new ApplicationName("uk-it-dev-alp");
	public static final ApplicationName UK_UNIXTEST = new ApplicationName("uk-unixtest");
	public static final ApplicationName UK_HELPDESK = new ApplicationName("uk_helpdesk");
	public static final ApplicationName UK_TRADEFLOOR = new ApplicationName("uk_tradefloor");
	public static final ApplicationName UKTEST = new ApplicationName("uktest");
	public static final ApplicationName UNIX = new ApplicationName("unix");
	public static final ApplicationName UNIX_SECURITY = new ApplicationName("unix_security");
	public static final ApplicationName UNIX_SECURITY_ENV = new ApplicationName("unix_security_env");
	public static final ApplicationName UNIX_SECURITY_MONITORING = new ApplicationName("unix_security_monitoring");
	public static final ApplicationName UNIX_SERVERS = new ApplicationName("unix_servers");
	public static final ApplicationName UNIX_SERVERS_AUTOGEN = new ApplicationName("unix_servers_autogen");
	public static final ApplicationName UNIX_SERVERS_WIP = new ApplicationName("unix_servers_work_in_progress");
	public static final ApplicationName USOE = new ApplicationName("usoe");
	public static final ApplicationName WEBADMIN = new ApplicationName("webadmin");
	public static final ApplicationName WINDOWS = new ApplicationName("windows");
	public static final ApplicationName WINFTS = new ApplicationName("winfts");
	public static final ApplicationName WINOSSPI_INSIGHT = new ApplicationName("winosspi-insight_manage");
	public static final ApplicationName WL_PRD = new ApplicationName("wl_prd");
	public static final ApplicationName WL_QA = new ApplicationName("wl_qa");
	public static final ApplicationName X_STATS = new ApplicationName("x_stats");

	/**
	 * 
	 */
	static {
		_instances.put(ACCOUNTS_BARCLAYSGLOBAL.toString(), ACCOUNTS_BARCLAYSGLOBAL);
		_instances.put(ADMINISTRATION.toString(), ADMINISTRATION);
		_instances.put(ADVANTAGE.toString(), ADVANTAGE);
		_instances.put(AIS.toString(), AIS);
		_instances.put(AIS_INCEPTION.toString(), AIS_INCEPTION);
		_instances.put(ALARMPOINT.toString(), ALARMPOINT);
		_instances.put(AMSX.toString(), AMSX);
		_instances.put(AMSX_LOAD.toString(), AMSX_LOAD);
		_instances.put(AP1.toString(), AP1);
		_instances.put(APEX.toString(), APEX);
		_instances.put(APP_DESK.toString(), APP_DESK);
		_instances.put(APPMANAGER.toString(), APPMANAGER);
		_instances.put(APPMANAGER_APPLICATION.toString(), APPMANAGER_APPLICATION);
		_instances.put(APPMANAGER_BACKUP.toString(), APPMANAGER_BACKUP);
		_instances.put(APPMANAGER_CIM.toString(), APPMANAGER_CIM);
		_instances.put(APPMANAGER_EXCHANGE.toString(), APPMANAGER_EXCHANGE);
		_instances.put(APPMANAGER_HELPDESK.toString(), APPMANAGER_HELPDESK);
		_instances.put(APPMANAGER_IIS.toString(), APPMANAGER_IIS);
		_instances.put(APPMANAGER_ISA.toString(), APPMANAGER_ISA);
		_instances.put(APPMANAGER_NT.toString(), APPMANAGER_NT);
		_instances.put(APPMANAGER_NTADMIN.toString(), APPMANAGER_NTADMIN);
		_instances.put(APPMANAGER_SQL.toString(), APPMANAGER_SQL);
		_instances.put(APPMANAGER_WTS.toString(), APPMANAGER_WTS);
		_instances.put(ARIA_JAP_CANOTICE.toString(), ARIA_JAP_CANOTICE);
		_instances.put(ARIA_JAP_CLIENT.toString(), ARIA_JAP_CLIENT);
		_instances.put(ARIA_JAP_CLIENTORDER.toString(), ARIA_JAP_CLIENTORDER);
		_instances.put(ARIA_JAP_EXECUTION.toString(), ARIA_JAP_EXECUTION);
		_instances.put(ARIA_JAP_FXRATE.toString(), ARIA_JAP_FXRATE);
		_instances.put(ARIA_JAP_GENERIC.toString(), ARIA_JAP_GENERIC);
		_instances.put(ARIA_JAP_LOANQUOTE.toString(), ARIA_JAP_LOANQUOTE);
		_instances.put(ARIA_JAP_ONLOAN.toString(), ARIA_JAP_ONLOAN);
		_instances.put(ARIA_JAP_RRR.toString(), ARIA_JAP_RRR);
		_instances.put(ARIA_JAP_UNITPRICE.toString(), ARIA_JAP_UNITPRICE);
		_instances.put(ART.toString(), ART);
		_instances.put(ASCOT.toString(), ASCOT);
		_instances.put(ASG.toString(), ASG);
		_instances.put(ASI.toString(), ASI);
		_instances.put(ASI_NETWORK.toString(), ASI_NETWORK);
		_instances.put(ASM.toString(), ASM);
		_instances.put(AUST_FTINTERACTIVE.toString(), AUST_FTINTERACTIVE);
		_instances.put(AUTOPACKAGER.toString(), AUTOPACKAGER);
		_instances.put(AUTOSYS.toString(), AUTOSYS);
		_instances.put(BACKUP.toString(), BACKUP);
		_instances.put(BARCLAYSGLOBAL.toString(), BARCLAYSGLOBAL);
		_instances.put(BEP.toString(), BEP);
		_instances.put(BG_ARIA.toString(), BG_ARIA);
		_instances.put(BG_AUS.toString(), BG_AUS);
		_instances.put(BG_CAN.toString(), BG_CAN);
		_instances.put(BGICASH.toString(), BGICASH);
		_instances.put(BGICASHFUNDS.toString(), BGICASHFUNDS);
		_instances.put(BGICONNECT_AUS.toString(), BGICONNECT_AUS);
		_instances.put(BGIFUNDS.toString(), BGIFUNDS);
		_instances.put(BGIS_FI_PROD.toString(), BGIS_FI_PROD);
		_instances.put(BGIS_FI_QA.toString(), BGIS_FI_QA);
		_instances.put(BGIS_UK.toString(), BGIS_UK);
		_instances.put(BGIS_UK_QA.toString(), BGIS_UK_QA);
		_instances.put(BGIS_US.toString(), BGIS_US);
		_instances.put(BIDBOOK.toString(), BIDBOOK);
		_instances.put(BIP.toString(), BIP);
		_instances.put(BLOOMBERG_RECON.toString(), BLOOMBERG_RECON);
		_instances.put(BMS.toString(), BMS);
		_instances.put(BRSI.toString(), BRSI);
		_instances.put(CALYPSO.toString(), CALYPSO);
		_instances.put(CANDEVEMAIL.toString(), CANDEVEMAIL);
		_instances.put(CAST.toString(), CAST);
		_instances.put(CENTAURI_UK.toString(), CENTAURI_UK);
		_instances.put(CERTIFICATE.toString(), CERTIFICATE);
		_instances.put(CFMAIL.toString(), CFMAIL);
		_instances.put(CHARLES_RIVER.toString(), CHARLES_RIVER);
		_instances.put(CHECKPOINT.toString(), CHECKPOINT);
		_instances.put(CIPIT.toString(), CIPIT);
		_instances.put(CITRIX.toString(), CITRIX);
		_instances.put(CLIENT_APPLICATIONS.toString(), CLIENT_APPLICATIONS);
		_instances.put(COM.toString(), COM);
		_instances.put(COM_SEC.toString(), COM_SEC);
		_instances.put(COMPACT.toString(), COMPACT);
		_instances.put(CONCERT.toString(), CONCERT);
		_instances.put(CP.toString(), CP);
		_instances.put(CP_MS_UK.toString(), CP_MS_UK);
		_instances.put(CPDL.toString(), CPDL);
		_instances.put(CPDL_JP.toString(), CPDL_JP);
		_instances.put(CR_UK.toString(), CR_UK);
		_instances.put(CRS.toString(), CRS);
		_instances.put(CRYSTAL_ENTERPRISE.toString(), CRYSTAL_ENTERPRISE);
		_instances.put(CSM.toString(), CSM);
		_instances.put(DATABASE.toString(), DATABASE);
		_instances.put(DATACENTER.toString(), DATACENTER);
		_instances.put(DBSPI.toString(), DBSPI);
		_instances.put(DBSSI.toString(), DBSSI);
		_instances.put(DELTA.toString(), DELTA);
		_instances.put(DELTA_UK.toString(), DELTA_UK);
		_instances.put(DEV_RPT.toString(), DEV_RPT);
		_instances.put(DEVICEQUERY.toString(), DEVICEQUERY);
		_instances.put(DEVNET.toString(), DEVNET);
		_instances.put(DEVTEST.toString(), DEVTEST);
		_instances.put(DOCUMENTUM.toString(), DOCUMENTUM);
		_instances.put(DYNAMO.toString(), DYNAMO);
		_instances.put(EAT.toString(), EAT);
		_instances.put(EMC_ALARMS.toString(), EMC_ALARMS);
		_instances.put(EMX.toString(), EMX);
		_instances.put(EQUILEND.toString(), EQUILEND);
		_instances.put(EQUILEND_B.toString(), EQUILEND_B);
		_instances.put(ESM.toString(), ESM);
		_instances.put(ETF.toString(), ETF);
		_instances.put(FI_SOVPLUS.toString(), FI_SOVPLUS);
		_instances.put(FI_BATCH.toString(), FI_BATCH);
		_instances.put(FIDAP.toString(), FIDAP);
		_instances.put(FIDS.toString(), FIDS);
		_instances.put(FLEXTRADE.toString(), FLEXTRADE);
		_instances.put(GAA_AASG.toString(), GAA_AASG);
		_instances.put(GAA_ACM.toString(), GAA_ACM);
		_instances.put(GAA_ADG.toString(), GAA_ADG);
		_instances.put(GAA_AIG.toString(), GAA_AIG);
		_instances.put(GAA_AMG.toString(), GAA_AMG);
		_instances.put(GAA_APLUS.toString(), GAA_APLUS);
		_instances.put(GAA_ASGINTL.toString(), GAA_ASGINTL);
		_instances.put(GAA_ASGUS.toString(), GAA_ASGUS);
		_instances.put(GAA_ATG.toString(), GAA_ATG);
		_instances.put(GAA_AURG.toString(), GAA_AURG);
		_instances.put(GAA_CNRG.toString(), GAA_CNRG);
		_instances.put(GAA_ETG.toString(), GAA_ETG);
		_instances.put(GAA_FASER.toString(), GAA_FASER);
		_instances.put(GAA_GAEPM.toString(), GAA_GAEPM);
		_instances.put(GAA_GAEPM_UK_AA.toString(), GAA_GAEPM_UK_AA);
		_instances.put(GAA_GAEPM_UK_ALPHA.toString(), GAA_GAEPM_UK_ALPHA);
		_instances.put(GAA_GROWTHEQ.toString(), GAA_GROWTHEQ);
		_instances.put(GAA_GTAA.toString(), GAA_GTAA);
		_instances.put(GAA_INTELLIS.toString(), GAA_INTELLIS);
		_instances.put(GAA_NEUALPHA.toString(), GAA_NEUALPHA);
		_instances.put(GAA_OTG.toString(), GAA_OTG);
		_instances.put(GAA_TPG.toString(), GAA_TPG);
		_instances.put(GAA_TRG.toString(), GAA_TRG);
		_instances.put(GAA_UKPM.toString(), GAA_UKPM);
		_instances.put(GAA_UNIX.toString(), GAA_UNIX);
		_instances.put(GAA_UNIX_AUTOGEN.toString(), GAA_UNIX_AUTOGEN);
		_instances.put(GAA_UNIX_WIP.toString(), GAA_UNIX_WIP);
		_instances.put(GAA_USAFI.toString(), GAA_USAFI);
		_instances.put(GAA_USSS.toString(), GAA_USSS);
		_instances.put(GATE.toString(), GATE);
		_instances.put(GCMFORM.toString(), GCMFORM);
		_instances.put(GCOM.toString(), GCOM);
		_instances.put(GDS.toString(), GDS);
		_instances.put(GEM.toString(), GEM);
		_instances.put(GFIT.toString(), GFIT);
		_instances.put(GIFT.toString(), GIFT);
		_instances.put(GIO.toString(), GIO);
		_instances.put(GIO_UNIX.toString(), GIO_UNIX);
		_instances.put(GITAP.toString(), GITAP);
		_instances.put(GLADIS.toString(), GLADIS);
		_instances.put(GLM.toString(), GLM);
		_instances.put(GLM2.toString(), GLM2);
		_instances.put(GLOBAL_ISHARES.toString(), GLOBAL_ISHARES);
		_instances.put(GLS_GATE.toString(), GLS_GATE);
		_instances.put(GMD.toString(), GMD);
		_instances.put(GMMT_APP_SERVER.toString(), GMMT_APP_SERVER);
		_instances.put(GMMT_SOA.toString(), GMMT_SOA);
		_instances.put(GMSG.toString(), GMSG);
		_instances.put(GOS.toString(), GOS);
		_instances.put(GOT_EUROPE.toString(), GOT_EUROPE);
		_instances.put(GOT_FTS.toString(), GOT_FTS);
		_instances.put(GOT_FTS_EMAIL.toString(), GOT_FTS_EMAIL);
		_instances.put(GOTUK.toString(), GOTUK);
		_instances.put(GPS.toString(), GPS);
		_instances.put(GSS_CFMAIL.toString(), GSS_CFMAIL);
		_instances.put(GSURVEYOR.toString(), GSURVEYOR);
		_instances.put(HA.toString(), HA);
		_instances.put(HARDCATWEB.toString(), HARDCATWEB);
		_instances.put(HARDWARE.toString(), HARDWARE);
		_instances.put(HDI.toString(), HDI);
		_instances.put(HELPDESK_UK.toString(), HELPDESK_UK);
		_instances.put(HELPME.toString(), HELPME);
		_instances.put(HFDP_DI.toString(), HFDP_DI);
		_instances.put(IA_US1.toString(), IA_US1);
		_instances.put(IA_US2.toString(), IA_US2);
		_instances.put(IBT_GATEWAY.toString(), IBT_GATEWAY);
		_instances.put(ICORE.toString(), ICORE);
		_instances.put(IDL.toString(), IDL);
		_instances.put(IMM.toString(), IMM);
		_instances.put(IMS.toString(), IMS);
		_instances.put(INDICES.toString(), INDICES);
		_instances.put(INFRADEV.toString(), INFRADEV);
		_instances.put(INTERNET_INFRASTRUCTURE.toString(), INTERNET_INFRASTRUCTURE);
		_instances.put(INTLPM.toString(), INTLPM);
		_instances.put(INTRASPECT.toString(), INTRASPECT);
		_instances.put(IPC.toString(), IPC);
		_instances.put(IPLANET.toString(), IPLANET);
		_instances.put(ISHARES.toString(), ISHARES);
		_instances.put(ISHARES_CA.toString(), ISHARES_CA);
		_instances.put(ISHARES_FI_BUS.toString(), ISHARES_FI_BUS);
		_instances.put(ISHARES_FI_DEV.toString(), ISHARES_FI_DEV);
		_instances.put(ISHARES_NET.toString(), ISHARES_NET);
		_instances.put(ISSUE_PRICE.toString(), ISSUE_PRICE);
		_instances.put(IUNITS.toString(), IUNITS);
		_instances.put(IWEB.toString(), IWEB);
		_instances.put(JAVAEE_SUPPORT.toString(), JAVAEE_SUPPORT);
		_instances.put(JOB.toString(), JOB);
		_instances.put(JRUN.toString(), JRUN);
		_instances.put(K2DESK.toString(), K2DESK);
		_instances.put(KM_IT_PS.toString(), KM_IT_PS);
		_instances.put(KMDP_DMSAPP.toString(), KMDP_DMSAPP);
		_instances.put(KMIT.toString(), KMIT);
		_instances.put(KMITPS.toString(), KMITPS);
		_instances.put(LOCKOUTS.toString(), LOCKOUTS);
		_instances.put(MAC.toString(), MAC);
		_instances.put(MARKET_DATA_EUROPE.toString(), MARKET_DATA_EUROPE);
		_instances.put(MARSHALL.toString(), MARSHALL);
		_instances.put(MISC.toString(), MISC);
		_instances.put(MQADMIN.toString(), MQADMIN);
		_instances.put(MQADMIN_SYD.toString(), MQADMIN_SYD);
		_instances.put(MQADMIN_TKY.toString(), MQADMIN_TKY);
		_instances.put(MQP_MQSERIES.toString(), MQP_MQSERIES);
		_instances.put(MSS_ADMIN.toString(), MSS_ADMIN);
		_instances.put(MSS_CONF.toString(), MSS_CONF);
		_instances.put(MSS_FAULT.toString(), MSS_FAULT);
		_instances.put(MSS_PERF.toString(), MSS_PERF);
		_instances.put(MSSQL_AMR.toString(), MSSQL_AMR);
		_instances.put(MSSQL_TEST.toString(), MSSQL_TEST);
		_instances.put(MULTI_CURR.toString(), MULTI_CURR);
		_instances.put(NAS.toString(), NAS);
		_instances.put(NAS_EMAIL.toString(), NAS_EMAIL);
		_instances.put(NETAPPS.toString(), NETAPPS);
		_instances.put(NETBACKUP.toString(), NETBACKUP);
		_instances.put(NETBACKUP_EMAIL.toString(), NETBACKUP_EMAIL);
		_instances.put(NETWORK.toString(), NETWORK);
		_instances.put(NETWORK_TEST.toString(), NETWORK_TEST);
		_instances.put(NODE_STATUS.toString(), NODE_STATUS);
		_instances.put(NOTIFICATION.toString(), NOTIFICATION);
		_instances.put(OFA.toString(), OFA);
		_instances.put(OPC.toString(), OPC);
		_instances.put(OPENDEPLOY.toString(), OPENDEPLOY);
		_instances.put(ORACLE.toString(), ORACLE);
		_instances.put(ORBIS.toString(), ORBIS);
		_instances.put(ORBIS_DISK_MONITORING1.toString(), ORBIS_DISK_MONITORING1);
		_instances.put(ORBIS_DISK_MONITORING2.toString(), ORBIS_DISK_MONITORING2);
		_instances.put(ORBIS_AUS.toString(), ORBIS_AUS);
		_instances.put(ORBIS_AUS_ESCALATE.toString(), ORBIS_AUS_ESCALATE);
		_instances.put(ORBIS_AUS_RISK.toString(), ORBIS_AUS_RISK);
		_instances.put(ORBIS_AUS_TRD.toString(), ORBIS_AUS_TRD);
		_instances.put(ORBIS_CAN.toString(), ORBIS_CAN);
		_instances.put(ORBIS_CAN_ESCALATE.toString(), ORBIS_CAN_ESCALATE);
		_instances.put(ORBIS_CAN_RISK.toString(), ORBIS_CAN_RISK);
		_instances.put(ORBIS_CAN_TRD.toString(), ORBIS_CAN_TRD);
		_instances.put(ORBIS_CROSSING.toString(), ORBIS_CROSSING);
		_instances.put(ORBIS_CST.toString(), ORBIS_CST);
		_instances.put(ORBIS_EQUITY.toString(), ORBIS_EQUITY);
		_instances.put(ORBIS_ESCALATE.toString(), ORBIS_ESCALATE);
		_instances.put(ORBIS_EUROPE.toString(), ORBIS_EUROPE);
		_instances.put(ORBIS_EUROPE_ESCALATE.toString(), ORBIS_EUROPE_ESCALATE);
		_instances.put(ORBIS_QA.toString(), ORBIS_QA);
		_instances.put(ORBIS_QA_UK.toString(), ORBIS_QA_UK);
		_instances.put(ORBIS_RM.toString(), ORBIS_RM);
		_instances.put(ORBIS_SUPPORT.toString(), ORBIS_SUPPORT);
		_instances.put(ORBIS_TRD.toString(), ORBIS_TRD);
		_instances.put(ORBIS_TRD_JAPAN.toString(), ORBIS_TRD_JAPAN);
		_instances.put(ORBIS_TRD_JAPAN_ESCALATE.toString(), ORBIS_TRD_JAPAN_ESCALATE);
		_instances.put(ORBIS_UK.toString(), ORBIS_UK);
		_instances.put(ORBIS_UK_CURRENCY.toString(), ORBIS_UK_CURRENCY);
		_instances.put(ORBIS_UK_EQUITY.toString(), ORBIS_UK_EQUITY);
		_instances.put(ORBIS_US_AUTO.toString(), ORBIS_US_AUTO);
		_instances.put(ORBIS_US_BREACH.toString(), ORBIS_US_BREACH);
		_instances.put(ORBIS_US_CURRENCY.toString(), ORBIS_US_CURRENCY);
		_instances.put(ORBIS_US_EQUITY.toString(), ORBIS_US_EQUITY);
		_instances.put(ORBIS_US_INDEX.toString(), ORBIS_US_INDEX);
		_instances.put(ORBIS_USIDXPM.toString(), ORBIS_USIDXPM);
		_instances.put(ORDERSONLINE.toString(), ORDERSONLINE);
		_instances.put(OS.toString(), OS);
		_instances.put(OSSPI_CLUSTERS.toString(), OSSPI_CLUSTERS);
		_instances.put(OSSPI_FS.toString(), OSSPI_FS);
		_instances.put(OSSPI_INTERNAL.toString(), OSSPI_INTERNAL);
		_instances.put(OSSPI_KERNEL.toString(), OSSPI_KERNEL);
		_instances.put(OSSPI_SERVICES.toString(), OSSPI_SERVICES);
		_instances.put(OVIS.toString(), OVIS);
		_instances.put(OZONE.toString(), OZONE);
		_instances.put(P3.toString(), P3);
		_instances.put(PACKAGING.toString(), PACKAGING);
		_instances.put(PARSW.toString(), PARSW);
		_instances.put(PB_RPT.toString(), PB_RPT);
		_instances.put(PERFORMANCE.toString(), PERFORMANCE);
		_instances.put(PIMS.toString(), PIMS);
		_instances.put(PREP.toString(), PREP);
		_instances.put(PRISM.toString(), PRISM);
		_instances.put(PURCHASING.toString(), PURCHASING);
		_instances.put(PURCHASING_WEB.toString(), PURCHASING_WEB);
		_instances.put(QPASA.toString(), QPASA);
		_instances.put(RK.toString(), RK);
		_instances.put(RKP.toString(), RKP);
		_instances.put(SAN.toString(), SAN);
		_instances.put(SAN_EMAIL.toString(), SAN_EMAIL);
		_instances.put(SAPPHIRE.toString(), SAPPHIRE);
		_instances.put(SATISHTEST.toString(), SATISHTEST);
		_instances.put(SEC_LENDING_SUPPORT.toString(), SEC_LENDING_SUPPORT);
		_instances.put(SECSVCS.toString(), SECSVCS);
		_instances.put(SECURITY.toString(), SECURITY);
		_instances.put(SENTINEL.toString(), SENTINEL);
		_instances.put(SENTRY.toString(), SENTRY);
		_instances.put(SERVICECENTER.toString(), SERVICECENTER);
		_instances.put(SHAREIT.toString(), SHAREIT);
		_instances.put(SHAREIT_TEST.toString(), SHAREIT_TEST);
		_instances.put(SNMP.toString(), SNMP);
		_instances.put(SOURCEFORGE.toString(), SOURCEFORGE);
		_instances.put(SPI_SVCDISC.toString(), SPI_SVCDISC);
		_instances.put(SPT_TKY_MN.toString(), SPT_TKY_MN);
		_instances.put(STATEMENT.toString(), STATEMENT);
		_instances.put(STORAGE.toString(), STORAGE);
		_instances.put(STORAGE_APAC.toString(), STORAGE_APAC);
		_instances.put(STORAGE_LDN.toString(), STORAGE_LDN);
		_instances.put(STORAGE_RDC.toString(), STORAGE_RDC);
		_instances.put(STORAGE_SFO.toString(), STORAGE_SFO);
		_instances.put(SUMS.toString(), SUMS);
		_instances.put(SWIFT.toString(), SWIFT);
		_instances.put(SWORDFISHWEBSERVICES.toString(), SWORDFISHWEBSERVICES);
		_instances.put(SYBASE.toString(), SYBASE);
		_instances.put(SYBASE_TEST.toString(), SYBASE_TEST);
		_instances.put(SYDDEV.toString(), SYDDEV);
		_instances.put(TAR.toString(), TAR);
		_instances.put(TEAMSITE.toString(), TEAMSITE);
		_instances.put(TECHTEAM.toString(), TECHTEAM);
		_instances.put(TELECOM.toString(), TELECOM);
		_instances.put(TELEDIRECT.toString(), TELEDIRECT);
		_instances.put(TEST.toString(), TEST);
		_instances.put(TEST_CS.toString(), TEST_CS);
		_instances.put(TESTCENTER.toString(), TESTCENTER);
		_instances.put(TKY_CDB.toString(), TKY_CDB);
		_instances.put(TKY_IT_BO.toString(), TKY_IT_BO);
		_instances.put(TKY_IT_GOT_JP.toString(), TKY_IT_GOT_JP);
		_instances.put(TKY_PAS.toString(), TKY_PAS);
		_instances.put(TKY_TPT.toString(), TKY_TPT);
		_instances.put(TKYDEV.toString(), TKYDEV);
		_instances.put(TORAPPS.toString(), TORAPPS);
		_instances.put(TORINFRA.toString(), TORINFRA);
		_instances.put(TRADEFLOOR.toString(), TRADEFLOOR);
		_instances.put(TRANSFER.toString(), TRANSFER);
		_instances.put(TRANSVC.toString(), TRANSVC);
		_instances.put(TRIPLEA.toString(), TRIPLEA);
		_instances.put(TSWEB.toString(), TSWEB);
		_instances.put(UK_IT_DEV.toString(), UK_IT_DEV);
		_instances.put(UK_IT_DEV_ALP.toString(), UK_IT_DEV_ALP);
		_instances.put(UK_UNIXTEST.toString(), UK_UNIXTEST);
		_instances.put(UK_HELPDESK.toString(), UK_HELPDESK);
		_instances.put(UK_TRADEFLOOR.toString(), UK_TRADEFLOOR);
		_instances.put(UKTEST.toString(), UKTEST);
		_instances.put(UNIX.toString(), UNIX);
		_instances.put(UNIX_SECURITY.toString(), UNIX_SECURITY);
		_instances.put(UNIX_SECURITY_ENV.toString(), UNIX_SECURITY_ENV);
		_instances.put(UNIX_SECURITY_MONITORING.toString(), UNIX_SECURITY_MONITORING);
		_instances.put(UNIX_SERVERS.toString(), UNIX_SERVERS);
		_instances.put(UNIX_SERVERS_AUTOGEN.toString(), UNIX_SERVERS_AUTOGEN);
		_instances.put(UNIX_SERVERS_WIP.toString(), UNIX_SERVERS_WIP);
		_instances.put(USOE.toString(), USOE);
		_instances.put(WEBADMIN.toString(), WEBADMIN);
		_instances.put(WINDOWS.toString(), WINDOWS);
		_instances.put(WINFTS.toString(), WINFTS);
		_instances.put(WINOSSPI_INSIGHT.toString(), WINOSSPI_INSIGHT);
		_instances.put(WL_PRD.toString(), WL_PRD);
		_instances.put(WL_QA.toString(), WL_QA);
		_instances.put(X_STATS.toString(), X_STATS);
	}
}
