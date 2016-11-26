package org.apache.hadoop.mapred;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by xiaoyue26 on 11/23/16.
 */
public class DebugClient {
    int breakNo;
    String objID;
    ObjectClientHandler handler;
    int debugNo=0;

    public DebugClient(ObjectClientHandler handler, String objID) {
        this.handler = handler;
        this.objID = objID;
        handler.objIDs.add(this.toString());
    }

    public void check(String line) {
        try {
            File log = new File("/home/xiaoyue26/test");
            String data = FileUtils.readFileToString(log);
            data += debugNo+":"+line+"\n";
            FileUtils.write(log, data);
            debugNo++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        //breakNo = handler.addBreakPoint(this.toString(), line);
        //while (handler.debuggerEnabled && handler.stopHere(this.toString(), breakNo)) {}
    }
}
