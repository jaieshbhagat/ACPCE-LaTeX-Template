\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{report}[2020/04/21 ACPCE Report Format]
\typeout{Document Class 'ACPCE - Report' v0.1 <21 Mar 20>}
\PassOptionsToClass{12pt,a4paper}{report}
\LoadClass{report}

\usepackage[english]{babel}
\usepackage[utf8]{inputenc}
\usepackage{indentfirst}
\usepackage{times}
\usepackage{graphicx}
\usepackage{tabularx}
\usepackage{array}
\usepackage{url}
\usepackage{longtable}
\usepackage{listings}
\usepackage{listings}
\usepackage{xcolor}
\usepackage[a4paper,bindingoffset=0.2in,left=0.8in,right=0.8in,top=0.8in,bottom=0.8in]{geometry}

\graphicspath{{./images/}}

%==================
% TABLE OF CONTENTS
%==================
% Redefining original table of contents.
%==================
\let\listoftablesORIG\listoftables
\renewcommand\listoftables{
    \listoftablesORIG
    \cleardoublepage
    \pagenumbering{arabic}
}

%==================
% BIBLIOGRAPHY
%==================
% Redefining bibliography.
%==================
\let\bibliographyORIG\bibliography
\renewcommand\bibliography[1]{
    \cleardoublepage
    \pagenumbering{alph}
    \addcontentsline{toc}{chapter}{\normalfont\textit{Bibliography}}
    \bibliographystyle{#1}
    \bibliographyORIG
}

%============================
% Golbal Variable Declaration
%============================
% ...
%============================
%New colors defined below
\definecolor{codegreen}{rgb}{0,0.6,0}
\definecolor{codegray}{rgb}{0.5,0.5,0.5}
\definecolor{codepurple}{rgb}{0.58,0,0.82}
\definecolor{backcolour}{rgb}{0.95,0.95,0.92}

%Code listing style named "mystyle"
\lstdefinestyle{mystyle}{
  backgroundcolor=\color{backcolour},   commentstyle=\color{codegreen},
  keywordstyle=\color{magenta},
  numberstyle=\tiny\color{codegray},
  stringstyle=\color{codepurple},
  basicstyle=\ttfamily\footnotesize,
  breakatwhitespace=false,         
  breaklines=true,                 
  captionpos=b,                    
  keepspaces=true,                 
  numbers=left,                    
  numbersep=5pt,                  
  showspaces=false,                
  showstringspaces=false,
  showtabs=false,                  
  tabsize=2
}

%"mystyle" code listing set
\lstset{style=mystyle}

\global\let\@guide\@empty
\global\let\@coguide\@empty
\global\let\@academicyear\@empty
\global\let\@department\@empty
\global\let\@degree\@empty
\global\let\@reportstage\@empty
\global\let\@hod\@empty
\global\let\@principal\@empty
\def\@declarationref{I}
\global\let\@declarationdate\@empty
\global\let\@declarationplace\@empty

%===========
% Variable Assignment
%===========
% 
%===========
\newcommand{\guide}[1]{\def\@guide{#1}}
\newcommand{\hod}[1]{\def\@hod{#1}}
\newcommand{\principal}[1]{\def\@principal{#1}}
\newcommand{\coguide}[1]{\def\@coguide{#1}}
\newcommand{\coauthor}[1]{\xdef\@author{\@author\par#1}
    \def\@declarationref{We}
}
\newcommand{\academicyear}[2]{\def\@academicyear{#1 - #2}}
\newcommand{\department}[1]{\def\@department{#1}}
\newcommand{\degree}[1]{\def\@degree{#1}}
\newcommand{\declarationdate}[2]{\def\@declarationdate{#1, #2}}
\newcommand{\declarationplace}[1]{\def\@declarationplace{#1}}
\newcommand{\degreespecialization}[1]{\xdef\@degree{\@degree{ }in #1}}
\newcommand{\reportstage}[1]{\def\@reportstage{Stage - 
\uppercase\expandafter{\romannumeral #1}\relax{ }}}

\renewcommand{\maketitle}{
  \begin{titlepage}
  \centering
	{\LARGE\bfseries \@title \par}
	\vspace{0.8cm}
	{\large A Project Report \@reportstage submitted in partial fulfillment of the requirements for the degree of \@degree\par}
	\vfill
	{\large by\par}
	\vfill
	{\Large \@author\par}
	\vfill
	{\large Under the guidance of\par}
	\vfill
	\Large{\expandafter{\@guide \par \@coguide}}
	\vfill
	\includegraphics[width=0.4\textwidth]{images/acpce_logo.png}\par
	\vfill
	{\Large \@department \par}
	{\large Jawahar Education Society's \par}
	{\Large A. C. Patil College of Engineering, Kharghar, Navi Mumbai \par}
	{\Large University of Mumbai \par}
	{\Large \@academicyear \par}
  \end{titlepage}
  \setcounter{page}{1} %title page is NOT counted
}

%===========
% DEDICATION
%===========
% The dedication environment must do the following:
% - start a new page
% - center the text vertically
% - include the text in a center environment
%===========
\def\dedication{
  \newpage
  \thispagestyle{empty}    % No page number
  \setcounter{page}{0}
  % \addtocounter{page}{-1}
  \chapter*{}            % Required for \vfill to work
  \thispagestyle{empty}    % No page number
  \null\vfil
  \begin{center}}
\def\enddedication{\end{center}\par\vfil\newpage}


%===
% CERTIFICATE
%===
% 
%====
\newcommand{\makecertificate}{
  %\setcounter{page}{2}
  \cleardoublepage
  \thispagestyle{empty}
  \begin{center}
\begin{table}[t]
\begin{tabular}{lc}
 \begin{tabular}[c]{@{}l@{}}
    \includegraphics[width=0.3\textwidth]{images/acpce_logo.png}
    \end{tabular} & \large\textbf{\begin{tabular}[c]{@{}c@{}}{Jawahar Education Society's,}\\{A. C. Patil College of Engineering, Kharghar}\\{\@department}\\{Academic Year \@academicyear}\end{tabular}} \\
\end{tabular}
\end{table}
\vspace{1cm}
\Huge\textbf{CERTIFICATE}
\vspace{1cm}
\\\large{This to certify that the project entitled}
\vspace{0.5cm}
\\\LARGE\textbf{``\@title''}
\vspace{0.5cm}
\\\large{by}
\vspace{0.5cm}
\\\Large\textbf{\@author}
\vspace{0.5cm}
\\\large{has successfully completed Project \@reportstage for the degree of \@degree as
prescribed by University of Mumbai.}
\vspace{2cm}
\ifx\@coguide\@empty
\begin{table}[h]
\begin{tabularx}{\textwidth} { >{\centering\arraybackslash}X  >{\centering\arraybackslash}X  >{\centering\arraybackslash}X }
   &  & \\\cline{1-1}\cline{3-3}
 {Guide}\newline{\@guide} &  & {H. O. D.}\newline{\@hod}\vspace{2cm}\\
  & & \\\cline{1-1}\cline{3-3}
 {External 1} &  & {External 2}\vspace{2cm}\\
 &&\\\cline{2-2}
  & {{Principal}\newline{\@principal}} & \\
\end{tabularx}
\end{table}
\else
    \begin{table}[h]
\begin{tabularx}{\textwidth} { >{\centering\arraybackslash}X  >{\centering\arraybackslash}X  >{\centering\arraybackslash}X }
  &  & \\\cline{1-1}\cline{3-3}
 {Guide}\newline{\@guide} &  & {Co - Guide}\newline{\@coguide}\vspace{2cm}\\
  & & \\\cline{1-1}\cline{3-3}
 {External 1} &  & {External 2}\vspace{2cm} \\
 &&\\\cline{1-1}\cline{3-3}
 {{H. O. D.}\newline{\@hod}} &  & {{Principal}\newline{\@principal}} \\
\end{tabularx}
\end{table}
\fi

\end{center}
}

%============
% DECLARATION
%============
% ...
%============
\newcommand{\makedeclaration}{
  \chapter*{Declaration}
  \thispagestyle{empty}
  \setcounter{page}{0}
  
  \large{\setlength{\parindent}{0cm}\setlength{\parskip}{1em}{\@declarationref}, hereby declare that this written submission represents my ideas and does not involve any plagiarism. I have adequately cited and referenced the original sources wherever others ideas or words have been include.
  \par
{\@declarationref} also declare that \lowercase\expandafter{\@declarationref} have adhered to all principles of academic honesty and integrity and have not misrepresented or fabricated or falsified any idea / data / fact / source in my submission.
\par
{\@declarationref} understand that any violation of the above will be cause for disciplinary action by the Institute and can also evoke penal action from the sources which have thus not been properly cited or from whom proper permission has not been taken when needed.}
  
  \vskip 1cm
  \large{\setlength{\parindent}{0cm}\setlength{\parskip}{0.5em}
    Date: \underline{\@declarationdate}\par
    Place: \underline{\@declarationplace}
  }
  \vskip 1cm
  {\setlength{\parindent}{0cm}\setlength{\parskip}{3em}\@author}
}

%=========
% ABSTRACT
%=========
% The abstract should begin with two single-spaced lines describing the author and title in a standard format. After these lines comes the standard abstract.
%=========
\def\abstract{
    \chapter*{Abstract}
    \addcontentsline{toc}{chapter}{\normalfont\textit{Abstract}}
    \relax\markboth{ABSTRACT}{ABSTRACT}}
    \pagenumbering{roman}
\def\endabstract{\par\newpage}

%================
% ACKNOWLEDGMENTS
%================
% The acknowledgments environment must do the following:
% - start a new page with ACKNOWLEDGMENTS centered two inches from the top
%================
\newcommand{\makeacknowledgement}{
  \chapter*{Acknowledgments}
  \thispagestyle{empty}
  
  \Large{\setlength{\parindent}{0cm}\setlength{\parskip}{1em}{\@declarationref} would like to thank my principal, {\@principal} sir for providing the required resources for the development of the project. {\@declarationref} would also like to thank H. O. D. {\@hod} sir
  \ifx\@coguide\@empty
    and \@guide for suggesting such a great project topic for college purpose and also being our guide.
  \else
    and {\@guide} and {\@coguide} for suggesting such a great project topic and also being our guides.
  \fi
  \par
{\@declarationref} sincerely thank them for helping, suggesting new ideas, providing a platform to showcase strength and also for guiding throughout the project.\par
{\@declarationref} express gratefulness to all the faculty members for their support and encouragement.
\par
Lastly, {\@declarationref} would like to thank friends and family members who gave strength and motivation
during the project.\par\vspace{5cm}
{\@declarationdate}}
}
