package com.bgi.essa.shared.primitive;

/**
 * @author coleguy
 */
public class ProcessSample {

	public ProcessSample(int pid, int seconds, TrimString name) {
		_pid = pid;
		_seconds = seconds;
		_name = name;
	}
	
	public ProcessSample(String arg) {
		String[] temp1 = arg.split(" ");
		if (temp1.length != 3) {
			throw new IllegalArgumentException("bad arg");
		}
		
		_pid = Integer.parseInt(temp1[0]);
		
		if (temp1[1].startsWith("(")) {
			//linux process names might be in parens, 
			//must be stripped to pacify downstream comparisons
			
			int limit = temp1[1].length();
			
			_name = new TrimString(temp1[1].substring(1, limit-1));
		} else {
			_name = new TrimString(temp1[1]);
		}
		
		_seconds = Integer.parseInt(temp1[2]);
	}
	
	public int getPid() {
		return(_pid);
	}
	
	public int getSeconds() {
		return(_seconds);
	}
	
	public TrimString getName() {
		return(_name);
	}
	
	private int _pid;
	private int _seconds;
	private TrimString _name;	
}
