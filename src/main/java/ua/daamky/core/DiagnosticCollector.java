package ua.daamky.core;

import ua.daamky.util.io.DiagnosticRecordWriter;

public interface DiagnosticCollector {
   int handle();

   void handle(DiagnosticRecordWriter var1);
}
