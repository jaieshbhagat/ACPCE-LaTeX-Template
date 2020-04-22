
# ACPCE-LaTeX-Template
LaTeX Template of A. C. Patil College of Engineering for developing project reports, thesis, journal papers, etc.

> Currently only supports project reports.
> Further, options for `research_papers`, `thesis`, etc. will be added.

## File / Folder Usage
| ***Name*** | ***Type*** | ***Use*** |
|--|--|--|
| `main.tex` | **File** | Main file which groups, drives and links various components of the document. |
| `figures` | **Folder** | This folder holds all figures that are or are to be referenced in the chapters. |
| `images` | **Folder** | Images that are not referred in chapters. Ex., Logo image, etc. |
| `code` | **Folder** | Images that are not referred in chapters. Ex., Logo image, etc. |
| `chapters` | **Folder** | Images that are not referred in chapters. Ex., Logo image, etc. |
| `class` | **Folder** | Holds various classes for templating various types of documents. <br><br>***Modifying, Edit or Deleting this file will result in*** **COMPILATION FAILURE** ***or produce*** **IMPROPER DOCUMENTS.** |

## Components of Document
| ***Document Class*** | ***Components*** |
|--|--|
| report | `title_page`<br>`dedication`<br>`certificate`<br>`declaration`<br>`abstract`<br>`dedication`<br>`table_of_contents`<br>`list_of_figures`<br>`list_of_tables`<br>`chapter`<br>`bibliography`<br>`acknowledgement` |
| thesis |  |


## Usage
main.tex is the main file which can be used to add/edit or remove components from the document.
### Document Declaration Commands
| ***Command*** | ***Mandatory*** | ***Behaviour*** | ***Example Usage*** | ***Required In Class(es)*** |
|--|--|--|--|--|
| `\documentclass{class/[filename]}` | **Yes** | Sets project template to be used. Path of class file to be used is to be provided to this command. | `\documentclass{class/report}`<br>`\documentclass{class/thesis}` | `report` |
| `\title{[String]}` | **Yes** | Sets title of document. | `\title{ACPCE Transactional System Using OAuth 2.0}` | `report` |
| `\reportstage{[Integer]}` | No | Sets Stage of document.<br>Ex., Project Report Stage II | `\reportstage{2}` | `report` |
| `\degree{[String]}` | **Yes** | Sets degree in document. | `\degree{Bachelor of Engineering}` | `report` |
| `\degreespecialization{[String]}` | **Yes** | Sets specialization or branch in document. | `\degreespecialization{Computer Engineering}` | `report` |
| `\department{[String]}` | **Yes** | Sets department in document. | `\department{Department of Computer Engineering}` | `report` |
| `\academicyear{[Integer\|start_year]}{[Integer\|end_year]}` | **Yes** | Sets academic year in document. | `\academicyear{2019}{2020}` | `report` |
| `\hod{String}` | **Yes** | Sets hod's name in `certificate`. | `\hod{Prof. R. C. Suryawanshi}` | `report` |
| `\principal{String}` | **Yes** | Sets principal name in `certificate`. | `\principal{Dr. V. N. Pawar}` | `report` |
| `\guide{String}`| **Yes** | Sets guide's name throughout document. |`\guide{Dr. M. M. Despande}` | `report` |
| `\coguide{String}`| No | Sets co-guide's name throughout document. (if applicable) |`\coguide{Prof. S. P. Bansu}` | `report` |
| `\author{String\|name (String\|prn)}` | **Yes** | Sets author's name throughout document. | `\author{Jaiesh Bhagat (151041042)}` | `report` |
| `\coauthor{String\|name (String\|prn)}` | No | Sets co-author's / group member's name throughout document. | `\coauthor{Pratul Sutar (151041042)}` | `report` |
| `\declarationdate{String\|day}{Integer\|dd\textsuperscript{String\|date_superscript} String\|month, Integer\|Year}` | **Yes** | Sets declaration date throughout document. |`\declarationdate{Wednesday}{22\textsuperscript{nd} March, 2020}` | `report` |
| `\declarationplace{String}` | **Yes** | Sets declaration date throughout document. | `\declarationplace{Navi Mumbai, Maharashtra}` | `report` |

### Document Component Commands
| ***Command*** | ***Mandatory*** | ***Required In Class(es)*** |
|--|--|--|
| `\begin{document}` | **Yes** | `report` |
| `\maketitle` | **Yes** | `report` |
| `\begin{dedication}<br>Your dedication here...<br>\end{dedication}` | No | `report` |
| `\makecertificate` | **Yes** | `report` |
| `\begin{abstract}<br>Your project abstract here...<br>\end{abstract}` | **Yes** | `report` |
| `\makedeclaration` | **Yes** | `report` |
| `\tableofcontents` | **Yes** | `report` |
| `\listoffigures` | **Yes** | `report` |
| `\listoftables` | **Yes** | `report` |
| `\include{chapters/chapter1}` | **Yes** | `report` |
| `\bibliography{plain}{chapters/bibliography}` | **Yes** | `report` |
| `\makeacknowledgement` | **Yes** | `report` |
> For behaviour of code and example, refer below code or go through `main.tex`

### Sample Code Functioning
```
\begin{document} % Document Scope Begins

\maketitle %Makes Title / Cover Page of document

\begin{dedication} %Adds 'Dedicated To' Page to the document
To my college...
\end{dedication}

\makecertificate %Adds Certificate Page to document

\makedeclaration %Adds Declaration Page to document

\begin{abstract} %Adds Abstract Page to document
This report specifies the various processes and techniques used in gathering requirements, designing, implementing and testing for the project on 'ACPCE Transactional System Using OAuth 2.0'. Existing problems with current system in the institute was analysed and noted. This project aims to solve some of the problems by creating a core software, development platforms for future works and to set up necessary infrastructure for maintaining transactional data for the institute, thus, adding more value to the current system. The requirements were gathered from various institute departments and stakeholders, based on which, requirement was modelled. A web application, using Java, MySQL and frameworks like Spring, Hibernate, Apache, etc, was designed to fulfil the modelled requirements. Features of the system includes, but are not limited to, Admissions, Student and Staff Dashboard, Examinations, Results, WebAdmin, ACPCE SSO and Attendance.
\end{abstract}

\tableofcontents %Adds Table of Contents Page to document
 
\listoffigures %Adds List of Figures Page to document
 
\listoftables %Adds List of Tables Page to document

\include{chapters/chapter1} % Adds Chapter 1 to document
\include{chapters/chapter2} % Adds Chapter 2 to document
\include{chapters/chapter3} % Adds Chapter 3 to document
\include{chapters/chapter4} %             .
\include{chapters/chapter5} %             .
             .                            .
             .                            .
             .                            .
\include{chapters/chapterk} % Adds Chapter k to document

               #1             #2
\bibliography{plain}{chapters/bibliography} % Adds Bibliography page to document.
                                            % '#1' defines type of bibliography to be used.
                                            % '#2' defines path to 'bibliography.bib' file.

\makeacknowledgement % Adds Acknowledgement page to document

\end{document} % Document Scope Ends
```
