package com.endcode.flightapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private Context context;

    private String[] webUrls;

    public ViewAdapter(Context context, String[] webUrls) {
        this.context = context;
        this.webUrls = webUrls;
    }
    public void setWebUrls(String[] webUrls) {
        this.webUrls = webUrls;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.webView.loadUrl(webUrls[position]);
    }

    @Override
    public int getItemCount() {
        return webUrls.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        WebView webView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            webView = itemView.findViewById(R.id.webview);
            webView.setWebViewClient(new WebViewClient());
        }
    }
}
