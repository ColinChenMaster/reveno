/** 
 *  Copyright (c) 2015 The original author or authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0

 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.reveno.atp.core.api;

import java.util.List;

public interface TransactionCommitInfo {
	
	long transactionId();
	
	TransactionCommitInfo transactionId(long transactionId);
	
	int version();
	
	TransactionCommitInfo version(int version);
	
	long time();
	
	TransactionCommitInfo time(long time);
	
	List<Object> transactionCommits();
	
	TransactionCommitInfo transactionCommits(List<Object> commands);
	
	
	public interface Builder {
		TransactionCommitInfo create();
	}
	
}