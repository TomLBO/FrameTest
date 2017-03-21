package com.example.retrofitdemo;

import com.liulishuo.filedownloader.connection.FileDownloadConnection;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by bob
 * on 17.3.13.
 */

public class PostFileDownloadConnection implements FileDownloadConnection {
    @Override
    public void addHeader(String name, String value) {

    }

    @Override
    public boolean dispatchAddResumeOffset(String etag, long offset) {
        return false;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    public Map<String, List<String>> getRequestHeaderFields() {
        return null;
    }

    @Override
    public Map<String, List<String>> getResponseHeaderFields() {
        return null;
    }

    @Override
    public String getResponseHeaderField(String name) {
        return null;
    }

    @Override
    public void execute() throws IOException {

    }

    @Override
    public int getResponseCode() throws IOException {
        return 0;
    }

    @Override
    public void ending() {

    }
}
