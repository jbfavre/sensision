//
//   Copyright 2016  Cityzen Data
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
//

package io.warp10.sensision;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.instrument.Instrumentation;

public class SensisionFileJMXAgent extends SensisionJMXPoller {
  
  private final SensisionMetricsDumper dumper;
  
  public SensisionFileJMXAgent(String agentArgs, Instrumentation instrumentation) {
    super(agentArgs, instrumentation);
    final SensisionFileJMXAgent self = this;
    
    dumper = new SensisionMetricsDumper() {      
      @Override
      public void dump(PrintWriter out) throws IOException {
        self.dump(out);
      }
    };
  }    
}
