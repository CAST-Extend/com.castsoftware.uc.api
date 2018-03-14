package com.castsoftware.jenkins.data;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Snapshot implements Comparable<Snapshot>
{
	public static final String FLD_SNAPSHOT_ID = "snapshot_id";
	public static final String FLD_APPLICATION_ID = "application_id";
	public static final String FLD_FUNCTIONAL_DATE = "functional_date";
	public static final String FLD_SNAPSHOT_TYPE_ID = "snapshot_type_id";
	public static final String FLD_SNAPSHOT_NAME = "snapshot_name";
	public static final String FLD_SNAPSHOT_DESCRIPTION = "snapshot_description";
	public static final String FLD_SNAPSHOT_DATE = "snapshot_date";
	public static final String FLD_COMPUTE_START_DATE = "compute_start_date";
	public static final String FLD_COMPUTE_END_DATE = "compute_end_date";
	public static final String FLD_SNAPSHOT_STATUS = "snapshot_status";

	static public final DateFormat DATE_CONVERTION = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

	private int snapshotId;
	private int applicationId;
	private String functionalDate;
	private int snapshotTypeId;
	private String snapshotName;
	private String snapshotDescription;
	private String snapshotDate;
	private String computeStartDate;
	private String computeEndDate;
	private int snapshotStatus;

	public Snapshot(int snapshotId, int applicationId, Timestamp functionalDate, int snapshotTypeId,
			String snapshotName, String snapshotDescription, Timestamp snapshotDate, Timestamp computeStartDate,
			Timestamp computeEndDate, int snapshotStatus)
	{
		super();
		this.snapshotId = snapshotId;
		this.applicationId = applicationId;
		this.functionalDate = convertTimestamp(functionalDate);
		this.snapshotTypeId = snapshotTypeId;
		this.snapshotName = snapshotName;
		this.snapshotDescription = snapshotDescription;
		this.snapshotDate = convertTimestamp(snapshotDate);
		this.computeStartDate = convertTimestamp(computeStartDate);
		this.computeEndDate = convertTimestamp(computeEndDate);
		this.snapshotStatus = snapshotStatus;
	}

	private String convertTimestamp(Timestamp ts)
	{
		return DATE_CONVERTION.format(new Date(ts.getTime()));
	}

	public int getSnapshotId()
	{
		return snapshotId;
	}

	public int getApplicationId()
	{
		return applicationId;
	}

	public String getFunctionalDate()
	{
		return functionalDate;
	}

	public int getSnapshotTypeId()
	{
		return snapshotTypeId;
	}

	public String getSnapshotName()
	{
		return snapshotName;
	}

	public String getSnapshotDescription()
	{
		return snapshotDescription;
	}

	public String getSnapshotDate()
	{
		return snapshotDate;
	}

	public String getComputeStartDate()
	{
		return computeStartDate;
	}

	public String getComputeEndDate()
	{
		return computeEndDate;
	}

	public int getSnapshotStatus()
	{
		return snapshotStatus;
	}

	@Override
	public int compareTo(Snapshot o)
	{
		Snapshot dd = (Snapshot) o;
		int c;
		try {
			c = DATE_CONVERTION.parse(getFunctionalDate()).compareTo(DATE_CONVERTION.parse(dd.getFunctionalDate()));
			if (c == 0) c = getApplicationId() - dd.getApplicationId();
		} catch (ParseException e) {
			c=0;
		}
		return c;
	}

}
