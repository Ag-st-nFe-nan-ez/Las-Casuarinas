@ECHO OFF

SETLOCAL
SET MVNW_CMD=.mvn\wrapper\mvnw.cmd
IF EXIST "%MVNW_CMD%" (
  CALL "%MVNW_CMD%" %*
) ELSE (
  SET BASEDIR=%~dp0
  IF EXIST "%BASEDIR%\.mvn\wrapper\mvnw.cmd" (
    CALL "%BASEDIR%\.mvn\wrapper\mvnw.cmd" %*
  ) ELSE (
    ECHO Cannot find .mvn\wrapper\mvnw.cmd in project directory or parent directories
    EXIT /B 1
  )
)
ENDLOCAL
