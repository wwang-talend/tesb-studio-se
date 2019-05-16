---
version: 6.3.1
module: https://talend.poolparty.biz/coretaxonomy/52
product:
- https://talend.poolparty.biz/coretaxonomy/24
---

# TPS-3130 <!-- mandatory -->

| Info             | Value |
| ---------------- | ---------------- |
| Patch Name       | Patch_20190516_TPS-3120_v1-6.3.1 |
| Release Date     | 2019-05-17 |
| Target Version   | 20161216_1026-6.3.1 |
| Product affected | Talend Studio |

## Introduction <!-- mandatory -->

This patch is cumulative. It includes all previous generally available patches for Talend Studio 6.3.1.

**NOTE**: For information on how to obtain this patch, reach out to your Support contact at Talend.

## Fixed issues <!-- mandatory -->

This patch contains the following fixes:

- TPS-3130 [6.3.1] twriteJsonField consumed 100% CPU (TESB-25705)

This patch also includes the following patches:

- TPS-1810 [6.3.1] new framework components support directory in studio(TDI-35748 & TUP-16774)
- TPS-1804 [6.3.1] Changing the order of output rows from tSAPBapi component breaks the code generation (TUP-17120)
- TPS-1826 [6.3.1] Upgrade issue with Jobs referencing joblets from a reference project (TUP-17201)
- TPS-1861 [6.3.1] Unable to connect to GIT when LDAP authentication set (no password)(TUP-17284)
- TPS-1821 [6.3.1] When publishing Routes, referenced Jobs are published with wrong groupId (TESB-18952)
- TPS-1856 [6.3.1] Commandline: Using reference project, will ignore custom-build settings for the project (TUP-17017
- TPS-1851 [6.3.1] Execution on jobserver from studio send all libs if tRunJob configuration was set as independent (TUP-16651)
- TPS-1888 [6.3.1] CDC Oracle Error(TUP-17437)
- TPS-1894 [6.3.1] Error with a job using nested joblets with MDM components (TUP-17194)
- TPS-1874 [6.3.1] Link names are renamed in jobs as Main1 when migrating from 5.4.1 to 6.2.1 (TUP-17245)
- TPS-1850 [6.3.1] OSX hits GC Overhead Error modifying salesforce metadata in jobs(TUP-17246)
- TPS-1902 [6.3.1] tHbaseinput issue when used in a joblet (TBD-4791)
- TPS-1928 [6.3.1] Unable to profile SQL Server NVARCHAR(MAX) (TDQ-13488)
- TPS-1890 [6.3.1] Need to simplify the branch creation of reference projects on Git Local(TUP-16722, TMC-9908)
- TPS-1913 [6.3.1] Different behavior on triggers between 611 and 621 (TUP-16161,TUP-17538)
- TPS-1917 [6.3.1] Some decimal-type columns of hive table lose precision when retrieving schema(TUP-17524)
- TPS-1899 [6.3.1] Cannot Connect to Kerberized Impala Server (CDH58) via Talend Studio 6.3.1 MetaData DB Connection (TUP-17433)
- TPS-1967 [6.3.1] tWebservice wsdl wizard don't works(TUP-17849)
- TPS-1935 [6.3.1] Renaming Schema causes "Access to data failure{0}"(TUP-17599)
- TPS-2017 [6.3.1] A Patch has broken the route's components 3rd party jars names (TESB-19863)
- TPS-2018 [6.3.1] Cannot Retrieve Columns from Metadata MapRDB Database Connection (TUP-18046)
- TPS-1962 [6.3.1] Cannot activate checkpointing in Spark Streaming job(TBD-4901)
- TPS-1886 [6.3.1] tParquetOutput shuffles the schema when run for the first time from studio(TBD-4795)
- TPS-2008 [6.3.1] Timestamp in Spark tHiveOutput (TBD-4354)
- TPS-2034 [6.3.1] Talend Unified Platform	tELTOracleMap / ELT Oracle Map Editor / left panel empty after migration from 6.1.1 to 6.3.1 (TUP-18158)
- TPS-1854 [6.3.1] Misleading Task Generation Status when jars are missing (TUP-17072)
- TPS-2029 [6.3.1] SVN error E160020 when copy to branch instead of window to Over Write or Compare Job (TUP-18143)
- TPS-2002 [6.3.1] Issue with the Choose context dialog when editing the job (TUP-18042)
- TPS-2056 [6.3.1] PATCH broke Build Job with sub-jobs from Reference project (TUP-18276)
- TPS-2057 [6.3.1] java.lang.NoSuchMethodError: org.apache.camel.util.IntrospectionSupport.extractStringProperties (TESB-19898)
- TPS-2062 [6.3.1] Patch installation have issues depends the license (TUP-17162)
- TPS-2063 [6.3.1] Null or empty date value will cause NPE when output to hive (TBD-5404)
- TPS-1985 [6.3.1] studio takes about 25 mins to update project settings for about 200 jobs in the project (TUP-17642,TUP-17643,TUP-17668)
- TPS-1918 [6.3.1] Studio crashing during startup with Failed to load the service :org.ops4j.pax.url.mvn.MavenResolver (TUP-17411)
- TPS-2068 [6.3.1] After sending a commit the dialog "Finishing integrity check" never ends (TUP-18215, TUP-17083)
- TPS-2097 [6.3.1] EMR 5.0.0 Spark Batch Error: Could not find or load main class org.apache.spark.deploy.yarn.ExecutorLauncher (TBD-4485)
- TPS-2105 [6.3.1] Impossible to use a new library across several tLibraryLoad (TUP-18405)
- TPS-2103 [6.3.1] Job fail to run use remote jobserver. (TUP-17036)
- TPS-2098 [6.3.1] Offline SVN project changes not committed to remote project(TUP-18380)
- TPS-2101 [6.3.1] tmap looses setting for Die on error(TUP-17050)
- TPS-2104 [6.3.1] Opening a BD job from the search feature in Studio transforms it into a DI job (TUP-18355)
- TPS-2146 [6.3.1] tLibraryLoad doesn't display the jars available in local maven (TUP-18489)
- TPS-2098 [6.3.1] Offline SVN project changes not committed to remote project (TUP-18380)
- TPS-2174 [6.3.1] Commandline: Using reference project, will ignore custom-build settings for the project (TUP-18570)
- TPS-2227 [6.3.1] Unable to Retrieve Schema if clicking multiple times in succession (TUP-18049)
- TPS-2214 [6.3.1] UHG - Configuring SVN Polling from TAC (TUP-18738)
- TPS-2209 [6.3.1] Could not find or load main class exception after building with CI Builder(TUP-18278)
- TPS-2224 [6.3.1] Issues with Retrieve schema from HDFS ( Encrypted zone) (TUP-18774)
- TPS-2018 [6.3.1] Cannot Retrieve Columns from Metadata MapRDB Database Connection (TUP-18046)
- TPS-2168:[6.3.1] FileNotFoundException: class path resource [META-INF/tesb/agent-context.xml] (TESB-20301)
- TPS-2240 [6.3.1] Stats&Logs still use JTDS driver even select Microsoft. (TUP-18492)
- TPS-2271 [6.3.1] Project reference from a project branch to another branch (TUP-19042)
- TPS-2277 [6.3.1] Request Patch for: " Studio unstability since the application of the patch: "Patch_20170117_TPS-1726_TPS-1688_v1-6.2.1.zip"" (TUP-17031)
- TPS-2289 [6.3.1] Unable to select or deselect used variables in select context variables window(TUP-19089)
- TPS-2292 [6.3.1] Talend Studio Frozen on updating the remote reference project (TUP-17236)
- TPS-2266 [6.3.1] CI Builder -DitemFilter=(version=0.1) does not work(TUP-18441)
- TPS-2301 [6.3.1] Exception when auditing any project on TAC (TUP-18571)
- TPS-2281 [6.3.1] Studio sending multiple "getLibLocation" metaservlet calls for each build activity (TUP-18208)
- TPS-2220 [6.3.1] BASE64Decoder and BASE64Encoder should be replaced by other class (TDQ-14095)
- TPS-2389 [6.3.1] TdqReportRun component doesn't work in remote job server (TDQ-14726)
- TPS-2423 [6.3.1] Child jobs are not being generated via itemfilter in CI Builder (TUP-19756)
- TPS-2366 [6.3.1] Errors when creating tSASoutput component from SAS metadata connection (TUP-19277)
- TPS-2423 [6.3.1] Child jobs are not being generated via itemfilter in CI Builder (TUP-19756)
- TPS-2590 [6.3.1] Migration tasks are re-executed and encrypting passwords (TUP-20391)
- TPS-2614 [6.3.1] Parquet components showing unexpected behavior after applying TPS-2097 on Talend studio 6.3.1 (TBD-7346)
- TPS-2658 [6.3.1] Wrong branch value in jobs generated by CI (TUP-20223)
- TPS-2684 [6.3.1] Guess schema is not working in case of tMSSQLinput component (TUP-18453,TUP-18189)
- TPS-2808 [6.3.1] Studio Crash using tmap component after McOS Mojave Upgrade (TUP-20866)
- TPS-2884 [6.3.1] When Deploying one customer's job in CI, the build failed with error: constant string too long(TDI-39029,TDI-39968)

## Prerequisites <!-- mandatory -->

Consider the following requirements for your system:

- Talend Studio 6.3.1 must be installed.

## Installation <!-- mandatory -->

<!--
- Detailed installation steps for the customer.
- If any files need to be backed up before installation, it should be mentioned in this section.
- Two scenarios need to be considered for the installation:
 1. The customer has not yet installed any patch before => provide instructions for this
 2. The customer had installed one previous cumulative patch => provide instructions for this
-->

### Installing the patch using Software update <!-- if applicable -->

1) Logon TAC and switch to Configuration->Software Update, then enter the correct values and save referring to the documentation: https://help.talend.com/reader/f7Em9WV_cPm2RRywucSN0Q/j9x5iXV~vyxMlUafnDejaQ

2) Switch to Software update page, where the new patch will be listed. The patch can be downloaded from here into the nexus repository.

3) On Studio Side: Logon Studio with remote mode, on the logon page the Update button is displayed: click this button to install the patch.

### Installing the patch using Talend Studio <!-- if applicable -->

1) Create a folder named "patches" under your studio installer directory and copy the patch .zip file to this folder.

2) Restart your studio: a window pops up, then click OK to install the patch, or restart the commandline and the patch will be installed automatically.

### Installing the patch using Commandline <!-- if applicable -->

Execute the following commands:

1. Talend-Studio-win-x86_64.exe -nosplash -application org.talend.commandline.CommandLine -consoleLog -data commandline-workspace startServer -p 8002 --talendDebug
2. initRemote {tac_url} -ul {TAC login username} -up {TAC login password}
3. checkAndUpdate -tu {TAC login username} -tup {TAC login password}
