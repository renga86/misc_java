    /*
     * Complete the solve function below.
     */
    static String[] solve(String[] arr) {
        /*
         * Write your code here.
         */
    	    HashMap<String, String> strMap = new HashMap<String, String>();
    	    HashMap<String, Integer> intMap = new HashMap<String, Integer>();
    		List<String> res = new ArrayList<String>();
        for(int i = 0; i < arr.length; i++) {
            String[] parts = arr[i].split(" ");
            if (strMap.containsKey(parts[0])) {
            		String val = strMap.get(parts[0]);
            		int val1 = intMap.get(parts[0]) + 1;
            		intMap.put(parts[0], val1);
            		int retVal = compareStrings(val, parts[1]);
            		if (retVal < 1)
            			strMap.put(parts[0], parts[1]);
            } else {
            		strMap.put(parts[0], parts[1]);
            		intMap.put(parts[0], 1);
            }
        }
        
        List<String> sortedKeys = new ArrayList<String>(strMap.keySet());
        Collections.sort(sortedKeys);
        
        for(int i = 0; i < strMap.size(); i++) {
        		String key = sortedKeys.get(i);
        		String strVal = strMap.get(key);
        		int cnt = intMap.get(key);
        		String output = key + ":" + cnt + "," + strVal;
        		res.add(output);
        }
        
        return res.toArray(new String[res.size()]);
    }

    static int compareStrings(String existString, String newString) {
    		return existString.compareTo(newString);
    }


