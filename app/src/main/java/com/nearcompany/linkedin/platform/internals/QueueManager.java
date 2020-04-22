/*
    Copyright 2014 LinkedIn Corp.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.nearcompany.linkedin.platform.internals;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class QueueManager {

    private static final String TAG = QueueManager.class.getName();
    private static QueueManager queueManager;
    private final Context ctx;
    private final RequestQueue requestQueue;

    private QueueManager(Context context) {
        this.ctx = context.getApplicationContext();
        this.requestQueue = Volley.newRequestQueue(this.ctx);
    }

    public static void initQueueManager(@NonNull Context ctx) {
        QueueManager.getInstance(ctx);
    }

    public static synchronized QueueManager getInstance(Context context) {
        if (QueueManager.queueManager == null) {
            QueueManager.queueManager = new QueueManager(context);
        }
        return QueueManager.queueManager;
    }

    public RequestQueue getRequestQueue() {
        return this.requestQueue;
    }


}